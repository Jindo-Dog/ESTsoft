package com.estsoft.estsoftspringdemoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringdemoproject.entity.Post;
import com.estsoft.estsoftspringdemoproject.model.PostRequest;
import com.estsoft.estsoftspringdemoproject.model.TestDTO;
import com.estsoft.estsoftspringdemoproject.model.TestDTO2;
import com.estsoft.estsoftspringdemoproject.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@GetMapping("/post/list")
	public ResponseEntity<List<Post>> getPostList(
		@RequestParam(name = "isDeleted", defaultValue = "false") Boolean isDeleted
	) {
		return ResponseEntity.ok(postService.getPostList(isDeleted));
	}

	@PostMapping("/post")
	public ResponseEntity<String> getPostList(@RequestBody PostRequest postRequest) {
		postService.createPost(postRequest);
		return ResponseEntity.ok("Success");
	}

	@GetMapping("/post/list/test")
	public ResponseEntity<List<TestDTO>> getPostListTest() {
		return ResponseEntity.ok(postService.getTest());
	}

	@GetMapping("/post/list/test2")
	public ResponseEntity<List<TestDTO2>> getPostListTest2() {
		return ResponseEntity.ok(postService.getPostWithCount());
	}
}
