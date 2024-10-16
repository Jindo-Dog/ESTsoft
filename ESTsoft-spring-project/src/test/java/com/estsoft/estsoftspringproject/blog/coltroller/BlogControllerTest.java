package com.estsoft.estsoftspringproject.blog.coltroller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.estsoft.estsoftspringproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.estsoftspringproject.blog.repository.BlogRepository;
import com.estsoft.estsoftspringproject.blog.service.BlogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {
	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BlogRepository repository;

	@Autowired
	private BlogService blogService;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		repository.deleteAll();
	}

	@Test
	@DisplayName("블로그 게시글 추가 API")
	public void addArticle() throws Exception {
		// given: article 저장
		/*Article article = Article.builder()
			.title("제목")
			.content("내용")
			.build();*/
		AddArticleRequest request = new AddArticleRequest("제목", "내용");
		// 직렬화 (object -> json)
		String json = objectMapper.writeValueAsString(request);

		// when: POST /articles aPI 호출
		ResultActions resultActions = mockMvc.perform(post("/articles")
			.contentType(MediaType.APPLICATION_JSON)
			.content(json));

		// then: response 검증
		resultActions.andExpect(status().isCreated())
			.andExpect(jsonPath("$.title").value(request.getTitle()))
			.andExpect(jsonPath("$.content").value(request.getContent()));

		List<Article> articleList = repository.findAll();
		assertThat(articleList.size()).isEqualTo(1);
	}

	@Test
	@DisplayName("블로그 게시글 전체 조회 API")
	public void findAll() throws Exception {
		// given: 조회 API에 필요한 값 세팅
		Article article = repository.save(new Article("title", "content"));

		// when: 조회 API
		ResultActions resultActions = mockMvc.perform(get("/articles")
			.accept(MediaType.APPLICATION_JSON));

		// then: API 호출
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].title").value(article.getTitle()))
			.andExpect(jsonPath("$[0].content").value(article.getContent()));
	}

	// data insert (id = 1), GET /articles/1
	@Test
	@DisplayName("블로그 게시글 단건 조회 API")
	public void findOne() throws Exception {
		// given: data insert
		Article article = repository.save(new Article("blog title", "blog content"));

		// when: API 호출
		ResultActions resultActions = mockMvc.perform(get("/articles/{id}", article.getId())
			.accept(MediaType.APPLICATION_JSON));

		// then: API 호출 결과 검증
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(article.getId()))
			.andExpect(jsonPath("$.title").value(article.getTitle()))
			.andExpect(jsonPath("$.content").value(article.getContent()));
	}

	@Test
	@DisplayName("블로그 게시글 단건 조회 API - 존재하지 않는 ID")
	public void findOneException() throws Exception {
		// when: API 호출
		ResultActions resultActions = mockMvc.perform(get("/articles/{id}", 1L)
			.accept(MediaType.APPLICATION_JSON));

		// then: Exception 검증, resultActions STATUS CODE 검증
		resultActions.andExpect(status().isBadRequest());
		assertThrows(IllegalArgumentException.class, () -> blogService.findBy(1L));
	}

	@Test
	@DisplayName("블로그 게시글 삭제 API")
	public void deleteOne() throws Exception {
		// given: data insert
		Article article = repository.save(new Article("blog title", "blog content"));

		// when: API 호출
		ResultActions resultActions = mockMvc.perform(delete("/articles/{id}", article.getId()));

		// then: API 호출 결과 검증
		resultActions.andExpect(status().isOk());    // status code 검증
		List<Article> articleList = repository.findAll();
		assertThat(articleList).isEmpty();    // 비어있는 Data 검증
	}

	// PUT /articles/{id} body(json content) 요청
	@Test
	@DisplayName("블로그 게시글 수정 API")
	public void updateArticle() throws Exception {
		Article article = repository.save(new Article("blog title", "blog content"));

		// 수정할 데이터(object) -> json
		UpdateArticleRequest request = new UpdateArticleRequest("updated title", "updated content");
		String updateJsonContent = objectMapper.writeValueAsString(request);

		ResultActions resultActions = mockMvc.perform(put("/articles/{id}", article.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.content(updateJsonContent)
		);
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value(request.getTitle()))
			.andExpect(jsonPath("$.content").value(request.getContent()));
	}

	// 수정 API 호출 시 예외가 발생할 경우(수정하려는 id가 존재하지 않을 경우) = status code 4xx, Exception 검증
	@Test
	@DisplayName("블로그 게시글 수정 API - 존재하지 않는 ID")
	public void updateArticleException() throws Exception {
		// given: request body
		Long notExisted = 1000L;
		UpdateArticleRequest request = new UpdateArticleRequest("updated title", "updated content");
		String updateJsonContent = objectMapper.writeValueAsString(request);

		// when: 수정 API 호출 (/articles/{id}, request body)
		ResultActions resultActions = mockMvc.perform(put("/articles/{id}", notExisted)
			.contentType(MediaType.APPLICATION_JSON)
			.content(updateJsonContent)
		);

		// then: 400 Bad Request
		resultActions.andExpect(status().isBadRequest());
		assertThrows(IllegalArgumentException.class, () -> blogService.update(notExisted, request));
		assertThrows(IllegalArgumentException.class, () -> blogService.findBy(notExisted));
	}
}