package com.estsoft.estsoftspringproject.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringproject.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}