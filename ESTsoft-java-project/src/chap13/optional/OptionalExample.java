package chap13.optional;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OptionalExample {
	public static void main(String[] args) {
		List<String> list = null;

		// list.stream().forEach(System.out::println);    // NullPointerException

		// Optional
		Optional<List<String>> optional = Optional.ofNullable(list);
		optional.orElseGet(Collections::emptyList)
			.forEach(System.out::println);

		Optional.ofNullable(list)
			.orElseGet(Collections::emptyList)
			.forEach(System.out::println);

		// Optional 객체 생성 (empty, of, ofNullable)
		Optional<Integer> empty = Optional.empty();
		OptionalInt empty2 = OptionalInt.empty();
		OptionalDouble empty3 = OptionalDouble.empty();

		Optional<Integer> optional2 = Optional.of(456);    // null값이 주어지면 NPE 발생

		Optional<Integer> optional3 = Optional.ofNullable(3289);    // null값을 줄 수 있음

		// Optional 객체 꺼내기 (get, isPresent, orElse, orElseGet, orElseThrow)
		Integer value = empty.orElse(123);    // 123
		Integer value2 = empty.orElseGet(() -> 123);    // 123

		List<String> newList1 = Optional.ofNullable(list)
			.orElse(Collections.emptyList());
		List<String> newList2 = Optional.ofNullable(list)
			.orElseGet(Collections::emptyList);  // 람다 표현식을 넣는 경우

		optional3.orElseThrow();
		// Integer i = empty.orElseThrow(() -> new NoSuchElementException());
		// Integer i = empty.orElseThrow(NoSuchElementException::new);
		Integer i = optional2.orElseThrow(NoSuchElementException::new);
		System.out.println(i);

		// isPresent
		if (optional3.isPresent()) {
			Integer integer = optional3.get();
			System.out.println(integer);    // 3289
		}
	}
}
