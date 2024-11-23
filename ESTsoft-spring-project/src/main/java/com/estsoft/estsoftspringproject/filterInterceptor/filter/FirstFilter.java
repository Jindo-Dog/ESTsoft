package com.estsoft.estsoftspringproject.filterInterceptor.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("FirstFilter init()");
	}

	@Override
	public void destroy() {
		log.info("FirstFilter destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("FirstFilter doFilter() request");

		// requestURI
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		log.info("RequestURI() = {}", httpServletRequest.getRequestURI());

		chain.doFilter(request, response);

		log.info("FirstFilter doFilter() response");
	}
}
