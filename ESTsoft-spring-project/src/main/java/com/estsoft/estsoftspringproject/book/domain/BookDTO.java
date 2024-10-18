package com.estsoft.estsoftspringproject.book.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDTO {
	private final String id;
	private final String name;
	private final String author;

	public BookDTO(Book book) {
		this.id = book.getId();
		this.name = book.getName();
		this.author = book.getAuthor();
	}
}
