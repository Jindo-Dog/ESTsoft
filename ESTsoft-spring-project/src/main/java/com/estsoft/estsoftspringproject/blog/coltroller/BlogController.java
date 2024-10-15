package com.estsoft.estsoftspringproject.blog.coltroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringproject.blog.domain.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.service.BlogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BlogController {
	private final BlogService service;

	public BlogController(BlogService service) {
		this.service = service;
	}

	// RequestMapping /articles
	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping("/articles")
	public ResponseEntity<Article> writeArticle(@RequestBody AddArticleRequest request) {
		// System.out.println(request.getTitle());
		// System.out.println(request.getContent());

		// logging level
		// trace, debug, info, warn, error
		log.warn("{}, {}", request.getTitle(), request.getContent());

		Article article = service.saveArticle(request);

		// 성공 201
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(article);
	}
}
