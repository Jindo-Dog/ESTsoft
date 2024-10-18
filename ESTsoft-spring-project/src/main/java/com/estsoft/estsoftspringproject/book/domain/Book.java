package com.estsoft.estsoftspringproject.book.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	private String id;

	@Column(nullable = false, columnDefinition = "VARCHAR(255)")
	private String name;

	@Column(nullable = false, columnDefinition = "VARCHAR(255)")
	private String author;
}
