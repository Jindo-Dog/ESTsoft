package chap06;

public class Calculator {
	int a;

	public Calculator() {
		// default 생성자
	}

	Calculator(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		int a = 1;
		Calculator calculator = new Calculator();
		int result = calculator.postfixOperator(a);
		System.out.println(result);

		// 2. Calculator cal 객체를 매개변수로 전달
		// 이 방식을 사용하지는 않는다
		Calculator cal1 = new Calculator(1);
		cal1.postfixOperator(cal1);
		System.out.println(cal1.a);
		System.out.println(cal1);

		// 3. 최종 : cal 객체 안의 a값을 변경해주는 메소드 호출
		Calculator cal2 = new Calculator();
		cal2.a = 1;
		cal2.postfixOperator();
		System.out.println(cal2.a);
	}

	void postfixOperator() {
		// a++;		// == this.a++;
		this.a++;
	}

	int postfixOperator(int a) {
		a++;
		return a;
	}

	void postfixOperator(Calculator cal) {
		cal.a++;
		System.out.println(cal);
	}
}
