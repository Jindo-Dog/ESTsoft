package com.estsoft.estsoftspringdemoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringdemoproject.repository.Member;
import com.estsoft.estsoftspringdemoproject.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository repository;

	/*public MemberService(MemberRepository repository) {	// DI
		this.repository = repository;
	}*/

	public List<Member> getAllMembers() {
		return repository.findAll();    // 멤버 목록 얻기
	}

	public Member saveMember(Member member) {
		return repository.save(member);    // 멤버 저장
	}
}
