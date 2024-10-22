package com.estsoft.estsoftspringproject.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.estsoftspringproject.book.domain.Book;
import com.estsoft.estsoftspringproject.book.domain.BookDTO;
import com.estsoft.estsoftspringproject.book.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// 책 정보 전체 조회
	@GetMapping
	public String showAll(Model model) {
		List<BookDTO> list = bookService.findAll()
			.stream()
			.map(BookDTO::new)
			.toList();

		model.addAttribute("bookList", list);
		return "bookManagement";
	}

	// 책 정보 단건 조회
	@GetMapping("/{id}")
	public String showOne(@PathVariable String id, Model model) {
		Book book = bookService.findBy(id);
		model.addAttribute("book", new BookDTO(book));
		return "bookDetail";
	}

	@PostMapping
	public String addBook(@RequestParam String id, @RequestParam String name, @RequestParam String author) {
		bookService.saveOne(new Book(id, name, author));
		return "redirect:/books";
	}
}