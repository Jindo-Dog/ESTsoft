package com.estsoft.estsoftspringproject.filterInterceptor.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class FirstFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FirstFilter.init()");
	}

	@Override
	public void destroy() {
		System.out.println("FirstFilter.destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("FirstFilter.doFilter() request");

		// requestURI
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		System.out.println("RequestURI() = " + httpServletRequest.getRequestURI());

		chain.doFilter(request, response);

		System.out.println("FirstFilter.doFilter() response");
	}
}
