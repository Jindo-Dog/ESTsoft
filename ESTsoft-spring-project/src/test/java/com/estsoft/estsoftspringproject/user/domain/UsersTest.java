package com.estsoft.estsoftspringproject.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public class UsersTest {
	private Users user;

	@BeforeEach
	public void setUp() {
		user = new Users("test@example.com", "password123", "ROLE_USER");
	}

	@Test
	public void testGetEmail() {
		assertThat(user.getUsername()).isEqualTo("test@example.com");
	}

	@Test
	public void testGetPassword() {
		assertThat(user.getPassword()).isEqualTo("password123");
	}

	@Test
	public void testGetAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)user.getAuthorities();
		assertThat(authorities).contains(new SimpleGrantedAuthority("user"));
		assertThat(authorities).contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Test
	public void testIsAccountNonExpired() {
		assertThat(user.isAccountNonExpired()).isTrue();
	}

	@Test
	public void testIsAccountNonLocked() {
		assertThat(user.isAccountNonLocked()).isTrue();
	}

	@Test
	public void testIsCredentialsNonExpired() {
		assertThat(user.isCredentialsNonExpired()).isTrue();
	}

	@Test
	public void testIsEnabled() {
		assertThat(user.isEnabled()).isTrue();
	}
}