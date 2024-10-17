package com.estsoft.estsoftspringproject.member.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
	private Long id;
	private String name;
	private int age;
	private List<String> hobbies;
}
