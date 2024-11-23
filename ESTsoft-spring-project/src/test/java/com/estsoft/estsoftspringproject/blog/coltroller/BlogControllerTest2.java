package com.estsoft.estsoftspringproject.blog.coltroller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.Comment;
import com.estsoft.estsoftspringproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentRequest;
import com.estsoft.estsoftspringproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.estsoftspringproject.blog.service.BlogService;
import com.estsoft.estsoftspringproject.blog.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(MockitoExtension.class)
public class BlogControllerTest2 {
	@InjectMocks
	BlogController blogController;

	@Mock
	BlogService blogService;

	@Mock
	CommentService commentService;

	MockMvc mockMvc;
	ObjectMapper objectMapper;

	// private Article article;
	// private Comment comment;

	@BeforeEach
	void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
		this.objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		/*article = new Article("test title", "test content");
		ReflectionTestUtils.setField(article, "id", 1L);

		comment = Comment.builder()
			.article(article)
			.body("test comment")
			.build();*/
	}

	// 블로그 게시글 정보를 저장하는 API 테스트
	@Test
	@DisplayName("게시글 저장 API")
	public void testSaveArticle() throws Exception {
		// given : API 호출에 필요한 데이터 만들기
		String title = "mock_title";
		String content = "mock_content";

		AddArticleRequest request = new AddArticleRequest(title, content);
		ObjectMapper objectMapper = new ObjectMapper();
		String articleJson = objectMapper.writeValueAsString(request);

		// stub (service.saveArticle 호출 시 위에서 만든 article을 리턴하도록 stub 처리)
		Mockito.when(blogService.saveArticle(any()))
			.thenReturn(new Article(title, content));

		// when : API 호출
		ResultActions resultActions = mockMvc.perform(
			post("/api/articles")
				.content(articleJson)
				.contentType(MediaType.APPLICATION_JSON)
		);

		// then : 호출 결과 검증
		resultActions.andExpect(status().isCreated())
			.andExpect(jsonPath("title").value(title))
			.andExpect(jsonPath("content").value(content))
		;

		verify(blogService).saveArticle(any(AddArticleRequest.class));
	}

	// DELETE /articles/{id} : 블로그 게시글 삭제 API 테스트
	@Test
	@DisplayName("게시글 삭제 API")
	public void testDelete() throws Exception {
		// given
		Long id = 1L;

		// when
		ResultActions resultActions = mockMvc.perform(delete("/api/articles/{id}", id));

		// then : HTTP status code 검증, service.deleteBy 검증
		resultActions.andExpect(status().isOk());

		verify(blogService, times(1)).deleteBy(id);
	}

	@Test
	@DisplayName("게시글 전체 조회 API")
	public void testFindAll() throws Exception {
		// given
		List<Article> articles = List.of(
			new Article("title1", "content1"),
			new Article("title2", "content2")
		);
		when(blogService.findAll()).thenReturn(articles);

		// when
		ResultActions resultActions = mockMvc.perform(get("/api/articles"));

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].title").value("title1"))
			.andExpect(jsonPath("$[1].title").value("title2"));

		verify(blogService).findAll();
	}

	// GET /articles/{id} : 블로그 게시글 단건 조회 API 테스트
	@Test
	@DisplayName("게시글 단건 조회 API")
	public void testFindOne() throws Exception {
		// given
		Long id = 1L;
		String expectedTitle = "title";
		String expectedContent = "content";

		// stubing : article 객체를 만들어준다
		Mockito.doReturn(new Article(expectedTitle, expectedContent))
			.when(blogService).findBy(id);

		// when
		ResultActions resultActions = mockMvc.perform(get("/api/articles/{id}", id));

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("title").value(expectedTitle))
			.andExpect(jsonPath("content").value(expectedContent))
		;

		verify(blogService).findBy(id);
	}

	/*@Test
	@DisplayName("게시글 단건 조회 실패 - 존재하지 않는 ID")
	public void testFindById_NotFound() throws Exception {
		// given
		Long id = 999L;
		when(blogService.findBy(id))
			.thenThrow(new IllegalArgumentException("not found id: " + id));

		// when
		ResultActions resultActions = mockMvc.perform(get("/api/articles/{id}", id));

		// then
		resultActions.andExpect(status().isBadRequest());
	}*/

	@Test
	@DisplayName("게시글 수정 API")
	public void testUpdate() throws Exception {
		// given
		Long id = 1L;
		UpdateArticleRequest request = new UpdateArticleRequest("updated_title", "updated_content");
		Article updatedArticle = new Article("updated_title", "updated_content");

		when(blogService.update(eq(id), any())).thenReturn(updatedArticle);

		// when
		ResultActions resultActions = mockMvc.perform(
			put("/api/articles/{id}", id)
				.content(objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON)
		);

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("title").value("updated_title"))
			.andExpect(jsonPath("content").value("updated_content"));

		verify(blogService).update(eq(id), any(UpdateArticleRequest.class));
	}

	@Test
	@DisplayName("댓글 작성 API")
	public void testAddComment() throws Exception {
		// given
		Long articleId = 1L;
		CommentRequest request = new CommentRequest("test comment");
		Article article = new Article("title", "content");
		Comment comment = Comment.builder()
			.article(article)
			.body("test comment")
			.build();

		when(commentService.saveComment(eq(articleId), any())).thenReturn(comment);

		// when
		ResultActions resultActions = mockMvc.perform(
			post("/api/articles/{id}/comments", articleId)
				.content(objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON)
		);

		// then
		resultActions.andExpect(status().isCreated())
			.andExpect(jsonPath("body").value("test comment"));
	}

	@Test
	@DisplayName("댓글 조회 API")
	public void testFindComment() throws Exception {
		// given
		Long commentId = 1L;
		Article article = new Article("title", "content");
		Comment comment = Comment.builder()
			.article(article)
			.body("test comment")
			.build();

		when(commentService.findBy(commentId)).thenReturn(comment);

		// when
		ResultActions resultActions = mockMvc.perform(get("/api/comments/{commentId}", commentId));

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("body").value("test comment"));
	}

	@Test
	@DisplayName("댓글 수정 API")
	public void testUpdateComment() throws Exception {
		// given
		Long commentId = 1L;
		CommentRequest request = new CommentRequest("updated comment");
		Article article = new Article("title", "content");
		Comment updatedComment = Comment.builder()
			.article(article)
			.body("updated comment")
			.build();

		when(commentService.update(eq(commentId), any())).thenReturn(updatedComment);

		// when
		ResultActions resultActions = mockMvc.perform(
			put("/api/comments/{commentId}", commentId)
				.content(objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON)
		);

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("body").value("updated comment"));
	}

	@Test
	@DisplayName("댓글 삭제 API")
	public void testDeleteComment() throws Exception {
		// given
		Long commentId = 1L;

		// when
		ResultActions resultActions = mockMvc.perform(delete("/api/comments/{commentId}", commentId));

		// then
		resultActions.andExpect(status().isOk());
		verify(commentService, times(1)).deleteBy(commentId);
	}

	@Test
	@DisplayName("게시글의 댓글 목록 조회 API")
	public void testFindCommentsByArticle() throws Exception {
		// given
		Long articleId = 1L;
		Article article = new Article("title", "content");
		List<Comment> comments = List.of(
			Comment.builder().article(article).body("comment1").build(),
			Comment.builder().article(article).body("comment2").build()
		);

		when(blogService.findBy(articleId)).thenReturn(article);
		when(commentService.findByArticle(article)).thenReturn(comments);

		// when
		ResultActions resultActions = mockMvc.perform(get("/api/articles/{id}/comments", articleId));

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("title").value("title"))
			.andExpect(jsonPath("comments[0].body").value("comment1"))
			.andExpect(jsonPath("comments[1].body").value("comment2"));
	}
}
