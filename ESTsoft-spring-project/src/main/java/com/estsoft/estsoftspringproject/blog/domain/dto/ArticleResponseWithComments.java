package com.estsoft.estsoftspringproject.blog.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "게시글과 댓글 리스트 응답", title = "게시글과 댓글 리스트")
public class ArticleResponseWithComments {
	@Schema(description = "게시글 ID", type = "Long", example = "12345")
	private Long articleId;

	@Schema(description = "게시글 제목", type = "String", example = "게시글 제목")
	private String title;

	@Schema(description = "게시글 내용", type = "String", example = "게시글 내용")
	private String content;

	@Schema(description = "게시글 생성 시간", example = "2024-10-13 12:00:00", format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createdAt;

	@Schema(description = "게시글 수정 시간", example = "2024-10-13 12:00:00", format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime updatedAt;

	@Schema(description = "댓글 리스트", type = "List<CommentResponse>")
	private List<CommentResponse> comments;

	public ArticleResponseWithComments(Article article, List<CommentResponse> comments) {
		this.articleId = article.getId();
		this.title = article.getTitle();
		this.content = article.getContent();
		this.createdAt = article.getCreatedAt();
		this.updatedAt = article.getUpdatedAt();
		this.comments = comments;
	}
}
