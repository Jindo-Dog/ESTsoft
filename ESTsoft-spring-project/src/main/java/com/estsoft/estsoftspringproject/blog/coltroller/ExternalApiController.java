package com.estsoft.estsoftspringproject.blog.coltroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleResponse;
import com.estsoft.estsoftspringproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.estsoftspringproject.blog.service.BlogService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class ExternalApiController {
	private final BlogService service;

	public ExternalApiController(BlogService service) {
		this.service = service;
	}

	@GetMapping("/external")
	public String callApi() {
		// 외부 API 호출
		RestTemplate restTemplate = new RestTemplate();
		// ResponseEntity<String> json = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", String.class);
		// log.info("StatusCode: {}", json.getStatusCode());
		// log.info(json.getBody());

		String url = "https://jsonplaceholder.typicode.com/posts";
		// 외부 API 호출, 역직렬화 (restTemplate)
		ResponseEntity<List<Content>> resultList = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
		});

		log.info("code: {}", resultList.getStatusCode());
		log.info("{}", resultList.getBody());

		return "OK";
	}

	@GetMapping("/external/articles")
	public ResponseEntity<List<ArticleResponse>> putApiArticles() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<List<Content>> resultList = restTemplate.exchange(
			url,
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<>() {
			});

		// body가 비어있을 경우 빈 리스트로 대체
		List<Content> contents = resultList.getBody() != null ? resultList.getBody() : new ArrayList<>();

		// 데이터를 변환하여 저장
		List<ArticleResponse> requests = contents.stream()
			.map(content -> service.saveArticle(new AddArticleRequest(content.getTitle(), content.getBody())).convert())
			.toList();

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(requests);
	}
}
