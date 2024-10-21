package com.estsoft.estsoftspringproject.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringproject.user.domain.Users;
import com.estsoft.estsoftspringproject.user.domain.dto.AddUserRequest;
import com.estsoft.estsoftspringproject.user.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository repository;

	// PW Encoder
	private final BCryptPasswordEncoder encoder;

	public UserService(UserRepository repository, BCryptPasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	// 회원가입 처리 (비즈니스 로직)
	public Users save(AddUserRequest dto) {
		String email = dto.getEmail();
		String password = dto.getPassword();
		String encodedPassword = encoder.encode(password);

		Users user = new Users(email, encodedPassword, "user");

		return repository.save(user);
	}
}
