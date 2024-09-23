package chap12;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 자바에서 제공하는 함수형 인터페이스 사용해서
 * 구현 객체를 람다식으로 작성하기
 *  Supplier
 *  Consumer
 *  Function
 *  Predicate
 */
public class LambdaExample2 {
	public static void main(String[] args) {
		System.out.println("===========Supplier===========");
		Supplier<String> supplier = () -> "str";
		String getStr = supplier.get();
		System.out.println(getStr);

		IntSupplier supplier2 = () -> 123;
		int getInt = supplier2.getAsInt();
		System.out.println(getInt);

		System.out.println("===========Consumer===========");

		// Consumer 함수형 인터페이스의 구현 객체를 람다식으로 작성하고 호출
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept("Consumer를 사용해서 입력값 출력하기");

		System.out.println("===========Function==============");

		// Function 구현 객체를 람다식으로 작성하고 호출
		Function<Integer, String> function = x -> String.valueOf(x) + ":문자열";
		System.out.println(function.apply(345));

		Function<String, Double> function2 = x -> Double.valueOf(x) * 1.2;
		System.out.println("String to Double: " + function2.apply("56.7"));

		System.out.println("===========Predicate==============");

		// Predicate 구현 객체를 람다식으로 작성
		// Predicate<String> isEmpty = x -> x.length() == 0;
		// Predicate<String> isEmpty = x -> x.isEmpty();
		Predicate<String> isEmpty = String::isEmpty;    // 클래스명::메소드명
		System.out.println("빈값 체크: " + isEmpty.test(""));
		System.out.println("빈값 체크: " + isEmpty.test("1234"));
		Predicate<Integer> predicate = x -> x % 2 == 0;
		System.out.println("짝수 체크: " + predicate.test(19));
	}
}
