package com.estsoft.estsoftspringproject.jpa.domain;

import jakarta.persistence.*;

@Entity
public class Locker {
	@Id
	@GeneratedValue
	@Column(name = "LOCKER_ID")
	private Long id;

	@Column(name = "name")
	private String name;

	// 일대일 양방향 연관관계 설정
	@OneToOne(mappedBy = "locker")
	private Members member;
}