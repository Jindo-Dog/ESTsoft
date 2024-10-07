package com.estsoft.estsoftspringdemoproject.lombok;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 롬복 적용해볼 People 클래스
 * -> 생성자, Getter, Setter 적용
 */
// POJO(Plain Old Java Object)
@AllArgsConstructor        // @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor
// @NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class People {
	private final Long id;
	private final String name;
	private int age;
	private List<String> hobbies;

	// 	@AllArgsConstructor로 대체 가능
	/*public People(Long id, String name, int age, List<String> hobbies) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}*/

	// @Getter, @Setter로 대체 가능
	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}*/
}
