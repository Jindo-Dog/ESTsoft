package com.estsoft.estsoftspringproject.blog.coltroller;

import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.estsoft.estsoftspringproject.blog.coltroller.externalAPI.CommentsContent;
import com.estsoft.estsoftspringproject.blog.coltroller.externalAPI.Content;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.Comment;
import com.estsoft.estsoftspringproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleResponse;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentRequest;
import com.estsoft.estsoftspringproject.blog.service.BlogService;
import com.estsoft.estsoftspringproject.blog.service.CommentService;

@ExtendWith(MockitoExtension.class)
class ExternalApiControllerTest {
	@InjectMocks
	ExternalApiController externalApiController;

	@Mock
	BlogService blogService;

	@Mock
	CommentService commentService;

	@Mock
	RestTemplate restTemplate;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(externalApiController).build();
	}

	@Test
	@DisplayName("외부 API 호출 테스트")
	void testCallApi() throws Exception {
		// given
		String expectedResult = "OK";

		// when & then
		mockMvc.perform(get("/api/external"))
			.andExpect(status().isOk())
			.andExpect(content().string(expectedResult));
	}

	@Test
	@DisplayName("외부 API 글 목록 가져오기 및 저장 테스트")
	void testApiArticles() throws Exception {
		// given
		String url = "https://jsonplaceholder.typicode.com/posts";
		List<Content> contentList = Arrays.asList(
			new Content("title1", "body1"),
			new Content("title2", "body2")
		);

		ResponseEntity<List<Content>> responseEntity = new ResponseEntity<>(contentList, HttpStatus.OK);

		// when
		lenient().when(restTemplate.exchange(
			eq(url),
			eq(HttpMethod.GET),
			isNull(),
			any(ParameterizedTypeReference.class)
		)).thenReturn(responseEntity);

		when(blogService.saveArticle(any(AddArticleRequest.class)))
			.thenReturn(new Article("title1", "body1"))
			.thenReturn(new Article("title2", "body2"));

		// then
		mockMvc.perform(get("/api/external/articles"))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$", hasSize(100)))
			.andExpect(jsonPath("$[0].title").value("title1"))
			.andExpect(jsonPath("$[0].content").value("body1"))
			.andExpect(jsonPath("$[1].title").value("title2"))
			.andExpect(jsonPath("$[1].content").value("body2"));

		verify(blogService, times(100)).saveArticle(any(AddArticleRequest.class));
	}

	@Test
	@DisplayName("외부 API 댓글 목록 가져오기 및 저장 테스트")
	void testApiComments() throws Exception {
		// given
		String url = "https://jsonplaceholder.typicode.com/comments";
		List<CommentsContent> commentsList = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			commentsList.add(new CommentsContent((long)(i % 20), "comment" + i));
		}

		ResponseEntity<List<CommentsContent>> responseEntity = new ResponseEntity<>(commentsList, HttpStatus.OK);

		Map<Long, Article> mockArticles = new HashMap<>();
		for (long i = 1; i <= 100; i++) {
			mockArticles.put(i, new Article("title" + i, "body" + i));
		}

		// when
		when(blogService.findBy(anyLong())).thenAnswer(invocation -> {
			Long articleId = invocation.getArgument(0);
			return mockArticles.get(articleId);
		});

		lenient().when(restTemplate.exchange(
			eq(url),
			eq(HttpMethod.GET),
			isNull(),
			any(ParameterizedTypeReference.class)
		)).thenReturn(responseEntity);

		when(commentService.saveComment(anyLong(), any(CommentRequest.class)))
			.thenAnswer(invocation -> {
				Long articleId = invocation.getArgument(0);
				CommentRequest request = invocation.getArgument(1);
				Article article = blogService.findBy(articleId);
				if (article == null) {
					throw new IllegalArgumentException("Article not found for ID: " + articleId);
				}
				return new Comment(article, request.getBody());
			});

		// then
		mockMvc.perform(get("/api/external/comments"))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$", hasSize(500)))
			.andExpect(
				jsonPath("$[0].body").value("""
					laudantium enim quasi est quidem magnam voluptate ipsam eos
					tempora quo necessitatibus
					dolor quam autem quasi
					reiciendis et nam sapiente accusantium"""));

		verify(commentService, times(500)).saveComment(anyLong(), any(CommentRequest.class));
	}
}