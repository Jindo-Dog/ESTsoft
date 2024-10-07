package com.estsoft.estsoftspringdemoproject.ioc;

public class A {
	Inter inter;

	// Dependency Injection & IoC(inter 객체의 제어권은 Spring에게 있음)
	public A(Inter inter) {
		this.inter = inter;
	}

	// 사용자가 직접 객체 제어
	// B -> C로 변경사항이 생겼을 때 코드 변경 범위 생각해보기
	public void method() {
		/*B objectB = new B();
		objectB.methodB();*/

		// 변경 시마다 새로운 클래스 로드
		// 코드 변경 범위가 커짐
		C objectC = new C();
		objectC.method();
	}

	// 생성자에서 클래스 주입하여 실행
	// 인터페이스로 객체 선언 : 변경에 유리
	public void method2() {
		inter.method();
	}
}
