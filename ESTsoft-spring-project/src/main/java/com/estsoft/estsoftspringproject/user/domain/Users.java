package com.estsoft.estsoftspringproject.user.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// @EntityListeners(AuditingEntityListener.class)
public class Users implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	/*@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;*/

	public Users(String email, String password, String auth) {
		this.email = email;
		this.password = password;
	}

	// 인가와 관련된 메소드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("user"));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	// 계정 만료 여부 반환 (true: 만료 안됨)
	@Override
	public boolean isAccountNonExpired() {
		// 각각 만료 여부를 체크하려면 컬럼을 추가하여 체크
		// 접속 날짜를 기준으로 만료 여부를 설정할 수도 있음
		return true;
	}

	// 계정 잠금 여부 반환 (true:잠금 안됨)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 패스워드의 만료 여부 반환 (true: 만료 안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정 사용 여부 반환 (true: 사용 가능)
	@Override
	public boolean isEnabled() {
		return true;
	}
}
