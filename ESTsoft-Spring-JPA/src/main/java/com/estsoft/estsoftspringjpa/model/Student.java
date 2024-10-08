package com.estsoft.estsoftspringjpa.model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
	private Long id;
	private String name;
	private Integer age;
	private String desc;
	private LocalDate createdAt;

	public Student(Long id, String name, Integer age, Date createdAt) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.createdAt = createdAt.toLocalDate();
	}
}
