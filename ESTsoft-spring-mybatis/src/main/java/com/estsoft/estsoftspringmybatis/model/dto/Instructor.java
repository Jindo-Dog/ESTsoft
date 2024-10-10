package com.estsoft.estsoftspringmybatis.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor {
	private Long id;
	private String name;
	private boolean left;
	private String desc;
	private LocalDate createdAt;
}
