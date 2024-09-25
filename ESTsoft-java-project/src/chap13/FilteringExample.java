package chap13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "b", "c", "c", "a");
		list.stream()
			.distinct()
			.forEach(System.out::print);

		System.out.println("\n--------------------------------");

		List<String> sentences = Arrays.asList("김밥", "김밥", "김치", "나비", "나방");
		Set<String> set = sentences.stream()
			.filter(s -> s.startsWith("김"))
			.collect(Collectors.toSet());    // Set<String>
		System.out.println(set);

		System.out.println("--------------------------------");

		String[] dupArray = {"김밥", "김밥", "김치", "나비", "나방"};
		Set<String> hashSet = Arrays.stream(dupArray).collect(Collectors.toSet());
		List<String> arrayList = Arrays.stream(dupArray).distinct().toList();
		System.out.println(hashSet);
		System.out.println(arrayList);
	}
}
