package com.estsoft.estsoftspringproject.blog.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "게시글 조회 결과", title = "게시글 조회")
public class ArticleResponse {
	@Schema(description = "게시글 ID", type = "Long", example = "1")
	private Long articleId;

	@Schema(description = "게시글 제목", type = "String", example = "제목")
	private String title;

	@Schema(description = "게시글 내용", type = "String", example = "내용")
	private String content;

	@Schema(description = "게시글 생성 시간", example = "2024-10-13 00:17:42", format = "yyyy-MM-dd HH:mm:ss", type = "LocalDateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createdAt;

	@Schema(description = "게시글 수정 시간", example = "2024-10-13 00:17:42", format = "yyyy-MM-dd HH:mm:ss", type = "LocalDateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime updatedAt;

	@Builder
	public ArticleResponse(Long articleId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
