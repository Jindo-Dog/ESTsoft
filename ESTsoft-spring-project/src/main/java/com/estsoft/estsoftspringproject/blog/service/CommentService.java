package com.estsoft.estsoftspringproject.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.Comment;
import com.estsoft.estsoftspringproject.blog.domain.dto.CommentRequest;
import com.estsoft.estsoftspringproject.blog.repository.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository repository;
	private final BlogService blogService;

	public CommentService(CommentRepository repository, BlogService blogService) {
		this.repository = repository;
		this.blogService = blogService;
	}

	@Transactional
	public Comment saveComment(Long articleId, CommentRequest request) {
		Article article = blogService.findBy(articleId);
		Comment comment = request.toEntity(article);
		return repository.save(comment);
	}

	public Comment findBy(Long id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id: " + id));
	}

	@Transactional
	public Comment update(Long id, CommentRequest request) {
		Comment comment = findBy(id);
		comment.update(request.getBody());
		return comment;
	}

	public void deleteBy(Long id) {
		repository.deleteById(id);
	}

	public List<Comment> findByArticle(Article article) {
		return repository.findAllByArticle(article);
	}
}
