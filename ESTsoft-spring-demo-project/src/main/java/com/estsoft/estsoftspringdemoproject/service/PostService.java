package com.estsoft.estsoftspringdemoproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.estsoftspringdemoproject.entity.Post;
import com.estsoft.estsoftspringdemoproject.model.PostRequest;
import com.estsoft.estsoftspringdemoproject.model.TestDTO;
import com.estsoft.estsoftspringdemoproject.model.TestDTO2;
import com.estsoft.estsoftspringdemoproject.repository.PostRepository;
import com.estsoft.estsoftspringdemoproject.repository.TestRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private TestRepository testRepository;

	public List<Post> getPostList(Boolean isDeleted) {
		return postRepository.findAllByIsDeletedOrderByCreatedAtDesc(isDeleted);
	}

	public Post getPost(Long postId, Boolean isDeleted) {
		return postRepository.findByIdAndIsDeleted(postId, isDeleted);
	}

	@Transactional
	public void createPost(PostRequest request) {
		Post post = new Post();
		post.setTitle(request.getTitle());
		post.setCategoryId(request.getCategoryId());
		post.setUserId(request.getUserId());
		post.setContent(request.getContent());
		post.setIsDeleted(false);
		post.setCreatedAt(LocalDateTime.now());
		post.setUpdatedAt(LocalDateTime.now());

		postRepository.save(post);
	}

	public List<TestDTO> getTest() {
		return testRepository.selectPostTest();
	}

	public List<TestDTO2> getPostWithCount() {
		return testRepository.selectPostWithCount();
	}
}
