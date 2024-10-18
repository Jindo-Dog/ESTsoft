package com.estsoft.estsoftspringproject.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringproject.book.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
