package com.estsoft.estsoftspringproject.filterInterceptor.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TestControllerTest {
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}

	@Test
	public void testQueryParameter() throws Exception {
		String testQuery = "hello world";

		mockMvc.perform(get("/test")
				.param("query", testQuery))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("query").value(testQuery));
	}

	@Test
	public void testEmptyQueryParameter() throws Exception {
		String testQuery = "";

		mockMvc.perform(get("/test")
				.param("query", testQuery))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("query").value(""));
	}
}