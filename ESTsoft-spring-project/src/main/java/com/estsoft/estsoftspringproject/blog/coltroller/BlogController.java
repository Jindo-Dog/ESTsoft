package com.estsoft.estsoftspringproject.blog.coltroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleResponse;
import com.estsoft.estsoftspringproject.blog.domain.dto.UpdateArticleRequest;
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
	public ResponseEntity<ArticleResponse> writeArticle(@RequestBody AddArticleRequest request) {
		// logging level
		// trace, debug, info, warn, error
		// log.warn("{}, {}", request.getTitle(), request.getContent());

		// Article article = service.saveArticle(request);

		/*ArticleResponse result = ArticleResponse.builder()
			.id(article.getId())
			.title(article.getTitle())
			.content(article.getContent())
			.build();*/

		// 성공 201
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(service.saveArticle(request).convert());
	}

	// Request Mapping 조회 : HTTP METHOD? GET
	@GetMapping("/articles")    // articles/1
	public ResponseEntity<List<ArticleResponse>> findAll() {
		// List<Article> -> List<ArticleResponse> 형태로 변환해서 응답으로 보내기
		List<ArticleResponse> list = service.findAll().stream()
			// .map(article -> new ArticleResponse(article.getId(), article.getTitle(), article.getContent()))
			.map(Article::convert)
			.toList();
		return ResponseEntity.ok(list);
	}

	// 단건 조회 API (Request Mapping) 만들기
	@GetMapping("/articles/{id}")
	public ResponseEntity<ArticleResponse> findById(@PathVariable(name = "id") Long id) {
		Article article = service.findBy(id);    // Exception (5xx server error) -> 4xx Status Code (Client Error)

		// Article -> ArticleResponse
		return ResponseEntity.ok(article.convert());
	}

	// DELETE /articles/{id}
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		service.deleteBy(id);
		return ResponseEntity.ok().build();
	}

	// PUT /articles/{id} 수정 API request body
	@PutMapping("/articles/{id}")
	public ResponseEntity<ArticleResponse> updateById(@PathVariable(name = "id") Long id, @RequestBody UpdateArticleRequest request) {
		Article updateArticle = service.update(id, request);
		return ResponseEntity.ok(updateArticle.convert());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(e.getMessage());
	}
}
