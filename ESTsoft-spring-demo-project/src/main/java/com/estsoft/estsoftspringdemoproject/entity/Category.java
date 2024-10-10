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
@Table(name = "categories")
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type")
	private String type;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "images")
	private String images;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
