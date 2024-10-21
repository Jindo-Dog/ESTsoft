package com.estsoft.estsoftspringproject.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.estsoft.estsoftspringproject.user.domain.dto.AddUserRequest;
import com.estsoft.estsoftspringproject.user.service.UserService;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// POST /user 요청을 받고 회원가입 처리 -> /login 리다이렉션
	@PostMapping("/user")
	public String save(@ModelAttribute AddUserRequest request) {
		userService.save(request);    // 회원 가입(저장)
		return "redirect:/login";    // 회원 가입 처리 후 로그인 페이지로 강제 이동
	}
}
