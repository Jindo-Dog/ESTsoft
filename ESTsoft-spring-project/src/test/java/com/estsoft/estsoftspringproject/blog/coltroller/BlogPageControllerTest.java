package com.estsoft.estsoftspringproject.blog.coltroller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.Comment;
import com.estsoft.estsoftspringproject.blog.service.BlogService;
import com.estsoft.estsoftspringproject.blog.service.CommentService;

@ExtendWith(MockitoExtension.class)
class BlogPageControllerTest {
	@InjectMocks
	BlogPageController blogPageController;

	@Mock
	BlogService blogService;

	@Mock
	CommentService commentService;

	MockMvc mockMvc;
	Authentication authentication;

	@BeforeEach
	void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(blogPageController).build();

		authentication = mock(Authentication.class, withSettings().lenient());
		SecurityContext securityContext = mock(SecurityContext.class, withSettings().lenient());
		lenient().when(securityContext.getAuthentication()).thenReturn(authentication);
		SecurityContextHolder.setContext(securityContext);
		lenient().when(authentication.getAuthorities()).thenReturn(Collections.emptyList());
	}

	@DisplayName("게시글 목록 페이지")
	@Test
	void testGetArticles() throws Exception {
		// given
		List<Article> articles = List.of(
			new Article("제목1", "내용1"),
			new Article("제목2", "내용2")
		);
		when(blogService.findAll()).thenReturn(articles);
		when(authentication.getAuthorities()).thenReturn(List.of());

		// when & then
		mockMvc.perform(get("/articles"))
			.andExpect(status().isOk())
			.andExpect(view().name("articleList"))
			.andExpect(model().attributeExists("articles"));
	}

	@DisplayName("게시글 상세 페이지")
	@Test
	void testShowArticle() throws Exception {
		// given
		Long articleId = 1L;
		Article article = new Article("제목1", "내용1");
		List<Comment> comments = List.of(
			new Comment(article, "내용1"),
			new Comment(article, "내용2")
		);

		when(blogService.findBy(articleId)).thenReturn(article);
		when(commentService.findByArticle(article)).thenReturn(comments);

		// when & then
		mockMvc.perform(get("/articles/{id}", articleId))
			.andExpect(status().isOk())
			.andExpect(view().name("article"))
			.andExpect(model().attributeExists("article"))
			.andExpect(model().attributeExists("comments"));
	}

	@DisplayName("게시글 작성 페이지")
	@Test
	void testNewArticle() throws Exception {
		// when & then
		mockMvc.perform(get("/new-article"))
			.andExpect(status().isOk())
			.andExpect(view().name("newArticle"))
			.andExpect(model().attributeExists("article"));
	}

	@DisplayName("게시글 수정 페이지")
	@Test
	void testEditArticle() throws Exception {
		// given
		Long articleId = 1L;
		Article article = new Article("제목1", "내용1");
		when(blogService.findBy(articleId)).thenReturn(article);

		// when & then
		mockMvc.perform(get("/new-article").param("id", String.valueOf(articleId)))
			.andExpect(status().isOk())
			.andExpect(view().name("newArticle"))
			.andExpect(model().attributeExists("article"));
	}
}