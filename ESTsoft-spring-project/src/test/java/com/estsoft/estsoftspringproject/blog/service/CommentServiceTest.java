package com.estsoft.estsoftspringproject.blog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.Comment;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentRequest;
import com.estsoft.estsoftspringproject.blog.repository.CommentRepository;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

	@InjectMocks
	private CommentService commentService;

	@Mock
	private CommentRepository commentRepository;

	@Mock
	private BlogService blogService;

	private Article testArticle;
	private Comment testComment;

	@BeforeEach
	void setup() {
		testArticle = Article.builder()
			.title("Test Title")
			.content("Test Content")
			.build();
		testArticle.setId(1L);

		testComment = Comment.builder()
			.article(testArticle)
			.body("Test Comment")
			.build();
	}

	@Test
	@DisplayName("saveComment: 댓글 저장 성공")
	void saveComment_ShouldSaveComment() {
		// Given
		Long articleId = 1L;
		CommentRequest request = new CommentRequest("New Comment");
		when(blogService.findBy(articleId)).thenReturn(testArticle);
		when(commentRepository.save(any(Comment.class))).thenAnswer(invocation -> invocation.getArgument(0));

		// When
		Comment result = commentService.saveComment(articleId, request);

		// Then
		assertThat(result).isNotNull();
		assertThat(result.getBody()).isEqualTo("New Comment");
		assertThat(result.getArticle()).isEqualTo(testArticle);
		verify(blogService).findBy(articleId);
		verify(commentRepository).save(any(Comment.class));
	}

	@Test
	@DisplayName("findBy: 댓글 조회 성공")
	void findBy_ShouldReturnComment() {
		// Given
		Long commentId = 1L;
		when(commentRepository.findById(commentId)).thenReturn(Optional.of(testComment));

		// When
		Comment result = commentService.findBy(commentId);

		// Then
		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(testComment);
		verify(commentRepository).findById(commentId);
	}

	@Test
	@DisplayName("findBy: 존재하지 않는 댓글 조회시 예외 발생")
	void findBy_ShouldThrowExceptionWhenCommentNotFound() {
		// Given
		Long commentId = 1L;
		when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

		// When & Then
		IllegalArgumentException exception = catchThrowableOfType(() -> commentService.findBy(commentId), IllegalArgumentException.class);
		assertThat(exception.getMessage()).isEqualTo("not found id: " + commentId);
		verify(commentRepository).findById(commentId);
	}

	@Test
	@DisplayName("update: 댓글 업데이트 성공")
	void update_ShouldUpdateComment() {
		// Given
		Long commentId = 1L;
		CommentRequest request = new CommentRequest("Updated Comment");
		when(commentRepository.findById(commentId)).thenReturn(Optional.of(testComment));

		// When
		Comment result = commentService.update(commentId, request);

		// Then
		assertThat(result).isNotNull();
		assertThat(result.getBody()).isEqualTo("Updated Comment");
		verify(commentRepository).findById(commentId);
	}

	@Test
	@DisplayName("deleteBy: 댓글 삭제 성공")
	void deleteBy_ShouldDeleteComment() {
		// Given
		Long commentId = 1L;

		// When
		commentService.deleteBy(commentId);

		// Then
		verify(commentRepository).deleteById(commentId);
	}

	@Test
	@DisplayName("findByArticle: 게시글로 댓글 목록 조회")
	void findByArticle_ShouldReturnComments() {
		// Given
		when(commentRepository.findAllByArticle(testArticle)).thenReturn(List.of(testComment));

		// When
		List<Comment> result = commentService.findByArticle(testArticle);

		// Then
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(1);
		assertThat(result.get(0)).isEqualTo(testComment);
		verify(commentRepository).findAllByArticle(testArticle);
	}
}