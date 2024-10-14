package com.estsoft.estsoftspringdemoproject.model;

import java.util.List;

import com.estsoft.estsoftspringdemoproject.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestDTO2 {
	private Long postId;
	private String title;
	private String content;
	private Long commentCount;
	private Long userId;
}
