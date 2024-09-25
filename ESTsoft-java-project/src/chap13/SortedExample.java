package chap13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortedExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("e", "a", "c", "z", "d");

		List<String> sortedList = list.stream()
			.sorted()
			.toList();
		System.out.println(sortedList);    // [a, c, d, e, z]

		List<String> sortedList2 = list.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println(sortedList2);    // [z, e, d, c, a]
	}
}
