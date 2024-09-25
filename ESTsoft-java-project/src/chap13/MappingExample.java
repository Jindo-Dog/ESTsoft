package chap13;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import chap10.wildcard.Person;

public class MappingExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		list.stream()
			.map(String::toUpperCase)
			.forEach(System.out::print);    // ABCDE

		System.out.println("\n--------------------------------");

		// flatmap	2차원 -> 1차원
		Integer[][] arr = {{1, 2}, {3, 4}};
		Arrays.stream(arr)
			.flatMap(Arrays::stream)
			.forEach(System.out::print);    // 1234

		System.out.println("\n--------------------------------");

		// flatmap
		List<String> sentences = Arrays.asList("Hello World", "Java stream");
		List<String> collect = sentences.stream()
			.flatMap(element -> Arrays.stream(element.split(" ")))
			// .collect(Collectors.toList());
			.toList();
		System.out.println(collect);    // [Hello, World, Java, stream]

		System.out.println("--------------------------------");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collect1 = numbers.stream()
			.map(n -> n * n)
			.toList();
		System.out.println(collect1);

		System.out.println("--------------------------------");

		List<String> sentences2 = Arrays.asList("Hello:World", "Java:stream:flatmap", "Functional:pogramming");
		List<String> collect2 = sentences2.stream()
			.flatMap(element -> Arrays.stream(element.split(":")))
			.toList();
		System.out.println(collect2);

		System.out.println("--------------------------------");

		List<List<Integer>> numbers2 = Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(4, 5, 6),
			Arrays.asList(7, 8, 9)
		);
		List<Integer> collect3 = numbers2.stream()
			.flatMap(List::stream)
			.toList();
		System.out.println(collect3);

		System.out.println("--------------------------------");

	}
}
