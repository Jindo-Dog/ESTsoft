package com.estsoft.estsoftspringproject.blog.domain;

import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	// Article 생성자
	@Builder
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public ArticleResponse convert() {
		return new ArticleResponse(this.id, this.title, this.content);
	}

	public void update(String title, String content) {
		if (!title.isBlank() && !content.isBlank()) {
			this.title = title;
			this.content = content;
		}
	}
}
