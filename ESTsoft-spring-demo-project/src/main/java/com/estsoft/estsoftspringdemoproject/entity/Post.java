package com.estsoft.estsoftspringdemoproject.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
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

	@OneToMany(mappedBy = "post")
	@JsonManagedReference
	private List<Comment> comments;
}
