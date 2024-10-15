package com.estsoft.estsoftspringproject.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringproject.blog.domain.Article;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
