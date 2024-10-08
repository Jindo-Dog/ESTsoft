package chap12;

import chap12.custom.MyFunctionalInterface;
import chap12.custom.MyFunctionalInterface2;
import chap12.custom.MyFunctionalInterface3;
import chap12.custom.MyFunctionalInterface4;

/**
 * 람다식 작성하기
 * 매개변수와 리턴값이 없는 익명 구현 객체 작성
 * 매개변수가 있는 람다식
 * 리턴타입이 있는 람다식
 */
public class LambdaExample {
	public static void main(String[] args) {
		// 람다식: 메소드를 간결하게 표현한 식
		// 자바에서는 람다식을 객체로 취급할 수 있음 (Java8 부터)

		// 익명 구현 객체
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 구현 객체의 메소드");
			}
		};

		// 람다식으로 구현한 익명 구현 객체
		Runnable runnable2 = () -> {
			System.out.println("람다식으로 구현한 익명 구현 객체의 메소드");
		};

		// 람다식을 작성하지 않고 익명 구현 객체 작성
		MyFunctionalInterface inter = new MyFunctionalInterface() {
			@Override
			public void run() {
				System.out.println("Hello Lambda1");
				System.out.println("Hello Lambda2");
				System.out.println("Hello Lambda3");
			}
		};
		inter.run();

		// 람다식 작성 - 매개변수, 리턴값이 없는 람다식
		// MyFunctionalInterface inter2 = () -> System.out.println("Hello Lambda");
		MyFunctionalInterface inter2 = () -> {
			System.out.println("Hello Lambda1");
			System.out.println("Hello Lambda2");
			System.out.println("Hello Lambda3");
		};
		inter2.run();

		// 매개변수가 있는 람다식
		MyFunctionalInterface2 inter3 = (x) -> System.out.println(x);
		inter3.method(10);

		// 매개변수와 리턴 타입이 있는 람다식 (매개변수 1개)
		MyFunctionalInterface3 inter4 = (x) -> x * x;
		System.out.println(inter4.method(10));

		// 매개변수와 리턴 타입이 있는 람다식 (매개변수 2개)
		MyFunctionalInterface4 inter5 = (x, y) -> {
			System.out.println("매개변수가 2개인 method");
			return x * y;
		};
		System.out.println(inter5.method(10, 20));

		MyFunctionalInterface4 inter6 = (i, j) -> i * j;    // 익명 구현 객체
		inter6.method(1, 5);
	}
}
