package com.estsoft.estsoftspringdemoproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringdemoproject.repository.Member;
import com.estsoft.estsoftspringdemoproject.service.MemberService;

@RestController
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/members")
	private List<Member> getAllMembers() {
		return memberService.getAllMembers();
	}

	// HTTP Post Method 요청(/members)을 받는 메소드
	@PostMapping("/members")
	public Member saveMember(@RequestBody Member member) {
		// member 정보를 저장하는 service 코드 호출
		return memberService.saveMember(member);
	}
}
