package com.estsoft.estsoftspringproject.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringproject.member.entity.Member;
import com.estsoft.estsoftspringproject.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository repository;

	//    public MemberService(MemberRepository repository) { // DI
	//        this.repository = repository;
	//    }

	public List<Member> getAllMembers() {
		return repository.findAll();        // Member 테이블 모든 정보 조회
		// SELECT * FROM member;
	}

	public Member saveMember(Member member) {
		return repository.save(member);
	}

}