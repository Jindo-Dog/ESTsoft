package chap12;

import java.util.function.ToIntBiFunction;

public class MethodParameterReferenceExample {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;

		// function = (a, b) -> a.compareToIgnoreCase(b);
		function = String::compareToIgnoreCase;
		System.out.println(function.applyAsInt("a", "A"));
	}

	void print(int order) {
		if (order < 0) {
			System.out.println("사전순으로 먼저 옵니다.");
		} else if (order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전순으로 나중에 옵니다.");
		}
	}
}