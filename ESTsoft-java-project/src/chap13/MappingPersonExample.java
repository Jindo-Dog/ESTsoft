package chap13;

import java.util.Arrays;
import java.util.List;

public class MappingPersonExample {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("Alice", 30),
			new Person("Bob", 25),
			new Person("Charlie", 28)
		);

		// 나이가 28세 이상인 사람들의 이름만 출력
		List<String> collect4 = people.stream()
			.filter(person -> person.age >= 28)
			.map(person -> person.name)
			.toList();
		System.out.println(collect4);
	}

	static class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
