package com.estsoft.estsoftspringproject.book.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringproject.book.domain.Book;
import com.estsoft.estsoftspringproject.book.domain.BookDTO;
import com.estsoft.estsoftspringproject.book.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> findAll() {
		return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));    // 오름차순
	}

	public Book findBy(String id) {
		return bookRepository.findById(id).orElse(new Book());
	}

	public Book saveOne(Book book) {
		return bookRepository.save(book);
	}
}
