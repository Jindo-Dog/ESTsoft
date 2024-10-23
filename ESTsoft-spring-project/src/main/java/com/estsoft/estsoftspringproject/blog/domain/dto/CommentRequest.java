package com.estsoft.estsoftspringproject.blog.domain.dto;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
	private String body;

	public Comment toEntity(Article article) {
		return Comment.builder()
			.article(article)
			.body(body)
			.build();
	}
}
