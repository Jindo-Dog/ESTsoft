package com.estsoft.estsoftspringdemoproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "category_id")
	private Long categoryId;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "is_deleted", columnDefinition = "TINYINT(1)")
	private Boolean isDeleted;
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
