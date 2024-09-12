package chap09.inherit;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent {
	/*@Override
	void method() throws IOException {
		// 자식의 Exception이 부모의 Exception보다 더 큰 범위이므로 컴파일 에러 발생
		// 반대의 경우는 가능하다
		// 단, 런타입 예외는 해당 규칙이 적용되지 않는다
		throw new IOException();
	}*/

	/*@Override
	void method() throws FileNotFoundException {
		throw new FileNotFoundException();
	}*/

	/*@Override
	void method() throws NumberFormatException {
		throw new NumberFormatException();
	}*/

	/*@Override
	void method() throws ClassCastException {
		throw new ClassCastException();
	}*/

	@Override
	void method() throws ArithmeticException {
		throw new ArithmeticException();
	}
}
