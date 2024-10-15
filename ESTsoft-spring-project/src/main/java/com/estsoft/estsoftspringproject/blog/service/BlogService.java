package com.estsoft.estsoftspringproject.blog.service;

import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringproject.blog.domain.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.repository.BlogRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlogService {
	private final BlogRepository repository;

	public BlogService(BlogRepository repository) {
		this.repository = repository;
	}

	// blog 게시글 저장
	// repository.save(Article)
	public Article saveArticle(AddArticleRequest request) {
		log.warn("반드시 서버에서 확인해야 하는 값 : {}", 1);
		log.warn("{}, {} service", request.getTitle(), request.getContent());

		return repository.save(request.toEntity());
	}
}
