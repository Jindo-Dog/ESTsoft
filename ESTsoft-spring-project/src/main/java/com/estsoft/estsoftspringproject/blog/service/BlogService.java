package com.estsoft.estsoftspringproject.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.estsoftspringproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.dto.UpdateArticleRequest;
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
		// log.warn("반드시 서버에서 확인해야 하는 값 : {}", 1);
		// log.warn("{}, {} service", request.getTitle(), request.getContent());

		return repository.save(request.toEntity());
	}

	// blog 게시글 전체 조회
	public List<Article> findAll() {
		return repository.findAll();
	}

	// blog 게시글 하나 조회 id(PK) 1건
	public Article findBy(Long id) {
		// Optional.orElse 시리즈
		// return repository.findById(id).orElse(new Article());
		// return repository.findById(id).orElseGet(Article::new);
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id: " + id));
	}

	// blog 게시글 삭제 (id)
	public void deleteBy(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	public Article update(Long id, UpdateArticleRequest request) {
		Article article = findBy(id);// 수정하고 싶은 Article 객체를 가져오기
		article.update(request.getTitle(), request.getContent());
		return article;
	}
}
