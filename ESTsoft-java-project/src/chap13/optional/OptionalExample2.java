package chap13.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample2 {
	public static void main(String[] args) {
		// List<Integer> list = new ArrayList<>();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// NoSuchElementException 예외 발생
		/*double avg = list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.getAsDouble();*/

		OptionalDouble optionalDouble = list.stream()
			.mapToInt(Integer::intValue)
			.average();

		/*if (optionalDouble.isPresent()) {
			double avg = optionalDouble.getAsDouble();
			System.out.println(avg);
		}*/

		double result = optionalDouble.orElse(0.0);
		System.out.println(result);

		optionalDouble.ifPresent(System.out::println);
	}
}
