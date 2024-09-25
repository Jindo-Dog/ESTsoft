package chap13;

import java.util.Arrays;
import java.util.List;

public class LoopingExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// 짝수를 걸러내서 총 합 구하기
		int sum = list.stream()
			.mapToInt(element -> element)
			.filter(element -> element % 2 == 0)
			.peek(System.out::print)    // 결과 단계의 메소드가 호출되지 않으면 실행되지 않는다
			.sum();
		System.out.println("짝수들의 총 합: " + sum);

		System.out.println("--------------------------------");

		// forEach(Sysout::print)
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		list2.stream()
			.filter(x -> x % 2 == 0)
			.forEach(System.out::println);

	}
}
