package com.estsoft.estsoftspringproject.user.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.estsoft.estsoftspringproject.user.domain.Users;

@DataJpaTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	// 사용자 이메일로 조회 기능 검증 테스트
	@Test
	public void testFindByEmail() {
		// given : (when절에서 조회하려는) 사용자 정보 저장
		Users user = getUser();
		userRepository.save(user);

		// when
		Users returnUser = userRepository.findByEmail(user.getEmail()).orElseThrow();

		// then
		assertThat(returnUser.getEmail(), is(user.getEmail()));
		assertThat(returnUser.getPassword(), is(user.getPassword()));
	}

	// 사용자 저장 기능
	@Test
	public void testSave() {
		// given
		Users user = getUser();

		// when
		Users saved = userRepository.save(user);

		// then
		assertThat(saved.getEmail(), is(user.getEmail()));
	}

	// 사용자 전체 조회 기능
	@Test
	public void testFindAll() {
		// given
		userRepository.save(new Users("test1@test.com", "pw1234", "user"));
		userRepository.save(new Users("test2@test.com", "pw1234", "user"));
		userRepository.save(new Users("test3@test.com", "pw1234", "user"));

		// when : findAll()
		List<Users> list = userRepository.findAll();

		// then : given 절에서 저장한 사용자 개수와 when 정레서 실제로 호출한 list의 개수가 같은지
		assertThat(list.size(), is(3));
	}

	private Users getUser() {
		String email = "test@test.com";
		String password = "pw1234";
		return new Users(email, password, "user");
	}
}