package com.estsoft.estsoftspringproject.blog.coltroller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.estsoft.estsoftspringproject.blog.domain.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.repository.BlogRepository;
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

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// POST /articles API 테스트
	@Test
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
}