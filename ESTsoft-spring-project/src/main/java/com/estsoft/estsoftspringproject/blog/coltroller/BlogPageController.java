package com.estsoft.estsoftspringproject.blog.coltroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.estsoftspringproject.blog.domain.Article;
import com.estsoft.estsoftspringproject.blog.domain.dto.ArticleViewResponse;
import com.estsoft.estsoftspringproject.blog.service.BlogService;

@Controller
public class BlogPageController {
	private final BlogService blogService;

	public BlogPageController(BlogService blogService) {
		this.blogService = blogService;
	}

	@GetMapping("/articles")
	public String getArticles(Model model) {
		List<Article> articleList = blogService.findAll();

		List<ArticleViewResponse> list = articleList.stream()
			.map(ArticleViewResponse::new)
			.toList();

		model.addAttribute("articles", list);

		return "articleList";    // articleList.html
	}

	@GetMapping("/articles/{id}")
	public String showArticle(@PathVariable Long id, Model model) {
		Article article = blogService.findBy(id);
		model.addAttribute("article", new ArticleViewResponse(article));

		return "article";
	}

	// id 키를 가진 queryParameter 값을 id변수에 매핑(id값이 없을 경우도 있음)
	// GET /new-article
	// GET /new-article?id={id}
	@GetMapping("/new-article")
	public String newArticle(@RequestParam(required = false) Long id, Model model) {
		if (id == null) {    // 새로운 게시글 생성
			model.addAttribute("article", new ArticleViewResponse());
		} else {    // 게시글 수정
			Article article = blogService.findBy(id);
			model.addAttribute("article", new ArticleViewResponse(article));
		}
		return "newArticle";    // newArticle.html
	}
}
