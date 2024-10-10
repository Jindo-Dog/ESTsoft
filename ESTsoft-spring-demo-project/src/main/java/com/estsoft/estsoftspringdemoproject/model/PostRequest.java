package com.estsoft.estsoftspringdemoproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
	private Long categoryId;    // 1L
	private String title;
	private String content;
	private Long userId;
}
