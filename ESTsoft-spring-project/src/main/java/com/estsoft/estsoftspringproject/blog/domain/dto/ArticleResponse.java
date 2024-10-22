package com.estsoft.estsoftspringproject.blog.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "블로그 조회 결과", title = "블로그 조회")
public class ArticleResponse {
	@Schema(description = "블로그 ID", type = "Long", example = "1")
	private Long id;
	@Schema(description = "블로그 제목", type = "String", example = "제목")
	private String title;
	@Schema(description = "블로그 내용", type = "String", example = "내용")
	private String content;

	@Builder
	public ArticleResponse(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
}
