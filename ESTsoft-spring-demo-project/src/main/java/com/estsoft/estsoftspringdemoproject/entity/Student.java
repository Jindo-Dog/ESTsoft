package com.estsoft.estsoftspringdemoproject.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private Integer age;
	@Column(name = "`desc`")    // JAVA에서는 예약어가 아니지만 MYSQL에서는 예약어이기 때문에 ``로 감싸준다
	private String desc;
	@Column(name = "created_at", updatable = false, nullable = false)
	// @CreatedDate    // == PrePersist
	private LocalDateTime createdAt;

	// 이 필드는 DB 컬럼으로는 존재하지 않는 상태지만 이 entity class에서는 개발자가 사용할 필드다
	@Transient
	private String nickName;

	@PrePersist
	public void prePersist() {
		// this.createdAt = LocalDateTime.now().truncatedTo((ChronoUnit.MILLIS));	// Table의 시간 속성 타입에 맞춤
		this.createdAt = LocalDateTime.now();
	}

	public String getNickName() {
		return this.name + "_(" + this.age + ")";
	}
}
