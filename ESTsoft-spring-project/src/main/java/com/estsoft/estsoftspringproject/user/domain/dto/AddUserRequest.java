package com.estsoft.estsoftspringproject.user.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원가입 요청 시 controller에서 입력받는 정보
 */
@Getter
@Setter
public class AddUserRequest {
	private String email;
	private String password;
}