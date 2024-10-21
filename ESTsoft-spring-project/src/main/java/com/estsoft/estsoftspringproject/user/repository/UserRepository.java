package com.estsoft.estsoftspringproject.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringproject.user.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	// SELECT * FROM users WHERE email = #{email}
	Optional<Users> findByEmail(String email);    // email로 사용자 정보를 가져옴
}
