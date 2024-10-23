package com.estsoft.estsoftspringproject.blog.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)    // 변경 시점 자동 반영
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column
	@CreatedDate
	private LocalDateTime createdAt;

	@Column
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	// Article 생성자
	@Builder
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public ArticleResponse convert() {
		return new ArticleResponse(this.id, this.title, this.content, this.createdAt, this.updatedAt);
	}

	public void update(String title, String content) {
		if (!title.isBlank() && !content.isBlank()) {
			this.title = title;
			this.content = content;
		}
	}
}
