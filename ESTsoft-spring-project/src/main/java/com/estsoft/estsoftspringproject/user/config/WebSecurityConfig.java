package com.estsoft.estsoftspringproject.user.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.estsoft.estsoftspringproject.user.service.UserDetailService;

@Configuration
public class WebSecurityConfig {
	private UserDetailService userDetailService;

	public WebSecurityConfig(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	/**
	 * 1. 스프링 시큐리티 기능 비활성화<br>
	 * 특정 요청은 스프링 시큐리티 설정을 타지 않게 ignore 처리
	 */
	@Bean
	public WebSecurityCustomizer ignore() {
		return web -> web.ignoring().requestMatchers(toH2Console())    // /h2-console
			.requestMatchers("/static/**");
	}

	/**
	 * 2. 특정 HTTP 요청에 대한 웹 기반 보안 구성
	 */
	// 구버전(3.6.1 이전)
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests()        // 3. 인증, 인가 성정
			.requestMatchers("/login", "/signup", "/user").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()    // 4. 폼 기반 호그인 설정
			.loginPage("/login")	// 로그인이 성공했을 경우 리다이렉트할 URL
			.defaultSuccessUrl("/articles")
			.and()
			.logout()    // 5. 로그아웃 설정
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.and()
			.csrf().disable()    // 6. CSRF 비활성화
			.build();
	}*/
	// 신버전
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(custom -> custom.requestMatchers("/login", "/signup", "/user")
				.permitAll()
				.requestMatchers("/articles/**").hasRole("ADMIN")    // ROLE_ADMIN (ROLE_는 자동으로 붙음) 역할로 본다
				// .requestMatchers("/articles/**").hasAuthority("ADMIN")    // ADMIN (ROLE_이 붙지 않음) 권한으로 본다
				.anyRequest()
				.authenticated())
			.formLogin(custom -> custom.loginPage("/login")
				.defaultSuccessUrl("/articles", true))
			.logout(custom -> custom.logoutSuccessUrl("/login")
				.invalidateHttpSession(true))
			.csrf(custom -> custom.disable())    // CSRF 비활성화
			.build();
	}

	/* 7. 인증관리자 관현 성정
	 * 이제 기본으로 설정되는 메소드*/
	/*@Bean
	public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
			.userDetailsService(userDetailService)    // 8. 사용자 정보 서비스 설정
			.passwordEncoder(bCryptPasswordEncoder)
			.and()
			.build();
	}*/

	/**
	 * 9. 패스워드 인코더로 사용할 빈 등록
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
