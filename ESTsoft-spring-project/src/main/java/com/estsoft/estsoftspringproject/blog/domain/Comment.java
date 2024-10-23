package com.estsoft.estsoftspringproject.blog.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.estsoft.estsoftspringproject.blog.domain.dto.CommentResponse;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentResponseWithArticle;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Long commentId;

	@Column
	private String body;

	@Column
	@CreatedDate
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;

	@Builder
	public Comment(Article article, String body) {
		this.article = article;
		this.body = body;
	}

	public CommentResponseWithArticle convertWithArticle() {
		return new CommentResponseWithArticle(this.commentId, this.body, this.createdAt, this.article);
	}

	public CommentResponse convert() {
		return new CommentResponse(this.commentId, this.article.getId(), this.body, this.createdAt);
	}

	public void update(String body) {
		if (!body.isBlank()) {
			this.body = body;
		}
	}
}
