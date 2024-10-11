package com.estsoft.estsoftspringdemoproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * com.estsoft.example 패키지 하위에 있는 빈 선언들도 Scan해서 빈 등록
 */
@Configuration
@ComponentScan(basePackages = "com.estsoft")
@EnableJpaRepositories(basePackages = {"com.estsoft"})
public class MyConfiguration {
	@PersistenceContext
	private EntityManager entityManager;

	// querydsl이 내부적으로는 (db랑 통신하는 단계에서는) entitymanager를 활용하는데,
	// entity -> query로 만들기 위한 단계에서는 entitu를 wrapping한 Q.xxxxx, JPAQUERYFACTORY
	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager);
	}
}
