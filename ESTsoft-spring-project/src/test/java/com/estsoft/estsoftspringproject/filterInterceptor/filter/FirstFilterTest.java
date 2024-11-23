package com.estsoft.estsoftspringproject.filterInterceptor.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class FirstFilterTest {
	private FirstFilter firstFilter;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private FilterChain chain;

	@BeforeEach
	public void setUp() {
		firstFilter = new FirstFilter();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		chain = mock(FilterChain.class);
	}

	@Test
	public void testDoFilter() throws ServletException, IOException {
		when(request.getRequestURI()).thenReturn("/test-uri");

		firstFilter.doFilter(request, response, chain);

		verify(request, times(1)).getRequestURI();
		verify(chain, times(1)).doFilter(request, response);
	}

	/*@Test
	public void testDestroy() {
		firstFilter.destroy();

		verify(mockLogger).info("FirstFilter destroy()");
	}*/
}