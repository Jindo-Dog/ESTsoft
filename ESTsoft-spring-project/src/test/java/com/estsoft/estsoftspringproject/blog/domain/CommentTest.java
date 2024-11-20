package com.estsoft.estsoftspringproject.blog.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleResponse;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentResponse;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentResponseWithArticle;

class CommentTest {
	@Test
	@DisplayName("Comment 생성 테스트")
	void createComment() {
		// given
		Article article = Article.builder()
			.title("테스트 제목")
			.content("테스트 내용")
			.build();
		String commentBody = "테스트 댓글";

		// when
		Comment comment = Comment.builder()
			.article(article)
			.body(commentBody)
			.build();

		// then
		assertThat(comment.getArticle()).isEqualTo(article);
		assertThat(comment.getBody()).isEqualTo(commentBody);
	}

	@Test
	@DisplayName("Comment를 CommentResponseWithArticle로 변환 테스트")
	void convertWithArticle() {
		// given
		Article article = Article.builder()
			.title("테스트 제목")
			.content("테스트 내용")
			.build();
		Comment comment = Comment.builder()
			.article(article)
			.body("테스트 댓글")
			.build();

		// when
		CommentResponseWithArticle response = comment.convertWithArticle();

		// then
		assertThat(response.getCommentId()).isEqualTo(comment.getCommentId());
		assertThat(response.getBody()).isEqualTo(comment.getBody());
		assertThat(response.getCreatedAt()).isEqualTo(comment.getCreatedAt());

		ArticleResponse articleResponse = response.getArticle();
		assertThat(articleResponse).isNotNull();
		assertThat(articleResponse.getArticleId()).isEqualTo(article.getId());
		assertThat(articleResponse.getTitle()).isEqualTo(article.getTitle());
		assertThat(articleResponse.getContent()).isEqualTo(article.getContent());
	}

	@Test
	@DisplayName("Comment를 CommentResponse로 변환 테스트")
	void convert() {
		// given
		Article article = Article.builder()
			.title("테스트 제목")
			.content("테스트 내용")
			.build();
		Comment comment = Comment.builder()
			.article(article)
			.body("테스트 댓글")
			.build();

		// when
		CommentResponse response = comment.convert();

		// then
		assertThat(response.getCommentId()).isEqualTo(comment.getCommentId());
		assertThat(response.getArticleId()).isEqualTo(article.getId());
		assertThat(response.getBody()).isEqualTo(comment.getBody());
		assertThat(response.getCreatedAt()).isEqualTo(comment.getCreatedAt());
	}

	@Test
	@DisplayName("Comment 내용 수정 테스트")
	void update() {
		// given
		Article article = Article.builder()
			.title("테스트 제목")
			.content("테스트 내용")
			.build();
		Comment comment = Comment.builder()
			.article(article)
			.body("원래 댓글")
			.build();
		String updatedBody = "수정된 댓글";

		// when
		comment.update(updatedBody);

		// then
		assertThat(comment.getBody()).isEqualTo(updatedBody);
	}

	@Test
	@DisplayName("Comment 내용이 비어있을 경우 수정되지 않음")
	void updateWithBlankBody() {
		// given
		Article article = Article.builder()
			.title("테스트 제목")
			.content("테스트 내용")
			.build();
		Comment comment = Comment.builder()
			.article(article)
			.body("원래 댓글")
			.build();
		String originalBody = comment.getBody();

		// when
		comment.update("   ");  // 공백만 있는 문자열

		// then
		assertThat(comment.getBody()).isEqualTo(originalBody);
	}
}