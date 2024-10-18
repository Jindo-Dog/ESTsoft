package com.estsoft.estsoftspringproject.filterInterceptor.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<Filter> firstFilter() {
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new FirstFilter());
		filter.setOrder(1);        // doFilter() 순서 보장
		filter.addUrlPatterns("/test");

		return filter;
	}

	@Bean
	public FilterRegistrationBean<Filter> secondFilter() {
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new SecondFilter());
		filter.setOrder(2);
		filter.addUrlPatterns("/test");

		return filter;
	}

	@Bean
	public FilterRegistrationBean<Filter> thirdFilter() {
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new ThirdFilter());
		filter.setOrder(3);
		filter.addUrlPatterns("/test");

		return filter;
	}
}
