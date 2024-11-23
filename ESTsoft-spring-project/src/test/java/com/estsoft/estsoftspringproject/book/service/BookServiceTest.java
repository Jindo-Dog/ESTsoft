package com.estsoft.estsoftspringproject.book.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.estsoft.estsoftspringproject.book.domain.Book;
import com.estsoft.estsoftspringproject.book.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@Test
	@DisplayName("전체 조회 테스트")
	public void testFindAll() {
		// Prepare test data
		Book book1 = new Book("1", "Test Book 1", "Author 1");
		Book book2 = new Book("2", "Test Book 2", "Author 2");
		List<Book> expectedBooks = Arrays.asList(book1, book2);

		// Mock repository method
		when(bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id")))
			.thenReturn(expectedBooks);

		// Call the method
		List<Book> actualBooks = bookService.findAll();

		// Verify
		assertThat(actualBooks).isEqualTo(expectedBooks);
		verify(bookRepository).findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Test
	@DisplayName("단건 조회 테스트 - 존재하는 책")
	public void testFindBy_ExistingBook() {
		// Prepare test data
		Book expectedBook = new Book("1", "Test Book", "Test Author");

		// Mock repository method
		when(bookRepository.findById("1"))
			.thenReturn(Optional.of(expectedBook));

		// Call the method
		Book actualBook = bookService.findBy("1");

		// Verify
		assertThat(actualBook).isEqualTo(expectedBook);
		verify(bookRepository).findById("1");
	}

	@Test
	@DisplayName("단건 조회 테스트 - 존재하지 않는 책")
	public void testFindBy_NonExistingBook() {
		// Mock repository method
		when(bookRepository.findById("999"))
			.thenReturn(Optional.empty());

		// Call the method
		Book actualBook = bookService.findBy("999");

		// Verify
		assertThat(actualBook)
			.hasFieldOrPropertyWithValue("id", null)
			.hasFieldOrPropertyWithValue("name", null)
			.hasFieldOrPropertyWithValue("author", null);
		verify(bookRepository).findById("999");
	}

	@Test
	@DisplayName("저장 테스트")
	public void testSaveOne() {
		// Prepare test data
		Book bookToSave = new Book("1", "New Book", "New Author");

		// Mock repository method
		when(bookRepository.save(bookToSave)).thenAnswer(invocation -> invocation.getArgument(0));

		// Call the method
		Book actualBook = bookService.saveOne(bookToSave);

		// Verify
		assertThat(actualBook).isEqualTo(bookToSave);
		verify(bookRepository).save(bookToSave);
	}
}