package com.estsoft.estsoftspringproject.book.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.estsoft.estsoftspringproject.book.domain.Book;
import com.estsoft.estsoftspringproject.book.repository.BookRepository;
import com.estsoft.estsoftspringproject.book.service.BookService;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {
	@Mock
	public BookService bookService;
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private BookRepository repository;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders
			.webAppContextSetup(context)
			.build();
		repository.deleteAll();
	}

	@Test
	public void showAll() throws Exception {
		// given
		// Book book = new Book(~~);
		// doReturn(bookList).when(bookService.findAll());

		// when
		ResultActions resultActions = mockMvc.perform(get("/books"));

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(view().name("bookManagement"))
			.andExpect(model().attribute("bookList", hasSize(2)))
		;
	}

	@Test
	void showOne() {
	}

	@Test
	void addBook() {
	}
}