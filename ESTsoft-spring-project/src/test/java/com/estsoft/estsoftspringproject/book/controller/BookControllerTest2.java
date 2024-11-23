package com.estsoft.estsoftspringproject.book.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.estsoft.estsoftspringproject.book.domain.Book;
import com.estsoft.estsoftspringproject.book.domain.BookDTO;
import com.estsoft.estsoftspringproject.book.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest2 {

	private MockMvc mockMvc;

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}

	@Test
	public void testShowAll() throws Exception {
		// Prepare test data
		Book book1 = new Book("1", "Test Book 1", "Author 1");
		Book book2 = new Book("2", "Test Book 2", "Author 2");
		List<Book> bookList = Arrays.asList(book1, book2);
		List<BookDTO> bookDTOList = bookList
			.stream()
			.map(BookDTO::new)
			.toList();

		// Mock the service method
		when(bookService.findAll()).thenReturn(bookList);

		// Perform the GET request and verify
		MvcResult result = mockMvc.perform(get("/books"))
			.andExpect(status().isOk())
			.andExpect(view().name("bookManagement"))
			.andExpect(model().attributeExists("bookList"))
			.andReturn();

		ModelAndView modelAndView = result.getModelAndView();
		List<BookDTO> resultBookList = (List<BookDTO>)modelAndView.getModel().get("bookList");

		assertThat(resultBookList)
			.usingRecursiveComparison()
			.isEqualTo(bookDTOList);
	}

	@Test
	public void testShowOne() throws Exception {
		// Prepare test data
		Book book = new Book("1", "Test Book", "Test Author");
		BookDTO bookDTO = new BookDTO(book);

		// Mock the service method
		when(bookService.findBy("1")).thenReturn(book);

		// Perform the GET request and verify
		MvcResult result = mockMvc.perform(get("/books/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("bookDetail"))
			.andExpect(model().attributeExists("book"))
			.andReturn();

		ModelAndView modelAndView = result.getModelAndView();
		BookDTO resultBook = (BookDTO)modelAndView.getModel().get("book");

		assertThat(resultBook)
			.usingRecursiveComparison()
			.isEqualTo(bookDTO);
	}

	@Test
	public void testAddBook() throws Exception {
		// Perform the POST request and verify
		mockMvc.perform(post("/books")
				.param("id", "1")
				.param("name", "New Book")
				.param("author", "New Author"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/books"));

		// Verify that saveOne was called with the correct book
		verify(bookService).saveOne(argThat(book ->
			book.getId().equals("1") &&
				book.getName().equals("New Book") &&
				book.getAuthor().equals("New Author")
		));
	}
}