package com.estsoft.estsoftspringproject.blog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticleResponse {
	private Long id;
	private String title;
	private String content;

	@Builder
	public ArticleResponse(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
}
