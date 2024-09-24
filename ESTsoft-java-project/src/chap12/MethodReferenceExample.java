package chap12;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {
	public static void main(String[] args) {
		IntBinaryOperator operator;

		// 정적 메소드 호출
		// operator = (left, right) -> Calculator.staticMethod(left, right);
		operator = Calculator::staticMethod;
		System.out.println("정적 메소드 호출 결과: " + operator.applyAsInt(1, 2));

		// 인스턴스 메소드 호출
		Calculator calculator = new Calculator();
		// operator = (left, right) -> calculator.instanceMethod(left, right);
		operator = calculator::instanceMethod;
		System.out.println("인스턴스 메소드 호출 결과: " + operator.applyAsInt(3, 5));
	}
}
