package com.estsoft.estsoftspringdemoproject.lombok;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LombokTest {
	@Test
	public void test() {
		People people = new People(1L, "name", 20, Arrays.asList("달리기", "등등"));
		people.setHobbies(Arrays.asList("그 외 취미", "..."));
		System.out.println(people.getHobbies());

		People people2 = new People(2L, "required 생성자 사용");
		System.out.println(people2.getName());
	}
}
