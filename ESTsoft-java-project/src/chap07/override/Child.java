package chap07.override;

public class Child extends Parent {
	@Override
	void method2() {
		System.out.println("Child의 method2 호출");
	}

	void method3() {
		System.out.println("Child의 method3 호출");
	}
}