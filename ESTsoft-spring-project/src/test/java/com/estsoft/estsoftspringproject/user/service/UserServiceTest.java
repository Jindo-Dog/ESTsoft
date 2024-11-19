package com.estsoft.estsoftspringproject.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.estsoft.estsoftspringproject.user.domain.Users;
import com.estsoft.estsoftspringproject.user.domain.dto.AddUserRequest;
import com.estsoft.estsoftspringproject.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@InjectMocks
	UserService userService;

	@Mock
	UserRepository repository;

	@Spy
	BCryptPasswordEncoder encoder;

	@Test
	public void testSave() {
		// given
		String email = "mock_email";
		String rawPassword = "mock_password";
		AddUserRequest request = new AddUserRequest();
		request.setEmail(email);
		request.setPassword(encoder.encode(rawPassword));

		Mockito.when(repository.save(any()))
			.thenReturn(new Users(request.getEmail(), request.getPassword(), "user"));

		// when
		Users returnUser = userService.save(request);

		//then
		assertEquals(request.getEmail(), returnUser.getEmail());
		assertEquals(request.getPassword(), returnUser.getPassword());

		verify(repository, times(1)).save(any(Users.class));
		verify(encoder, times(2)).encode(any(String.class));
	}
}