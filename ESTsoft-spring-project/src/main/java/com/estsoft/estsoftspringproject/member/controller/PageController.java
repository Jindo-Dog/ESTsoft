package com.estsoft.estsoftspringproject.member.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	// Person	GET /thymeleaf/example
	@GetMapping("/thymeleaf/example")
	public String show(Model model) {
		Person person = new Person();
		person.setId(1L);
		person.setName("김자바");
		person.setAge(20);
		person.setHobbies(Arrays.asList("줄넘기", "멀뛰기", "헬스"));

		model.addAttribute("person", person);
		model.addAttribute("today", LocalDateTime.now());
		
		return "examplePage";
	}
}
