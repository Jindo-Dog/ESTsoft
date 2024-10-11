package com.estsoft.estsoftspringdemoproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estsoft.estsoftspringdemoproject.model.CommentRequest;
import com.estsoft.estsoftspringdemoproject.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/comment")
	public ResponseEntity<Void> createComment(@RequestBody CommentRequest request) {
		commentService.createComment(request);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/most/commented")
	public List<Object[]> getMostCommentPost() {
		return commentService.getMostCommentPost();
	}
}