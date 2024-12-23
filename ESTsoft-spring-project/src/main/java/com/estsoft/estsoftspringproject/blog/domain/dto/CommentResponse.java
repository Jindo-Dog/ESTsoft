package com.estsoft.estsoftspringproject.blog.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "댓글 조회 결과", title = "댓글 조회")
public class CommentResponse {
	@Schema(description = "댓글 ID", type = "Long", example = "1")
	private Long commentId;

	@Schema(description = "게시글 ID", type = "Long", example = "1")
	private Long articleId;

	@Schema(description = "댓글 내용", type = "String", example = "내용")
	private String body;

	@Schema(description = "댓글 생성 시간", example = "2024-10-13 00:17:42", format = "yyyy-MM-dd HH:mm:ss", type = "LocalDateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createdAt;

	@Builder
	public CommentResponse(Long commentId, Long articleId, String body, LocalDateTime createdAt) {
		this.commentId = commentId;
		this.articleId = articleId;
		this.body = body;
		this.createdAt = createdAt;
	}
}
