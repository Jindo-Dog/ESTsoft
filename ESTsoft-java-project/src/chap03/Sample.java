package chap03;

public class Sample {
	public static void main(String[] args) {
		// 단항 연산자
		/*int x = 14;
		int result = --x;
		System.out.println(result);
		System.out.println(--x);*/

		int a = 10;
		int b = 3;

		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);

		System.out.println("----------------------");

		byte x = 45;
		byte y = 67;

		int result = x + y;
		System.out.println(result);

		// byte result2 = x + y;    // int로 변환된 후 연산이 수행되기 때문에 형변환이 필요하다

		System.out.println("----------------------");

		int x2 = 51;
		float y2 = 50.66F;

		int intResult = (int)(x2 + y2);
		int intResult3 = (int)(x2 - y2);
		int intResult4 = x2 - (int)y2;
		double doubleResult = x2 - y2;

		System.out.println(intResult);
		System.out.println(intResult3);
		System.out.println(intResult4);
		System.out.println(doubleResult);

		System.out.println("----------------------");

		// char 타입
		char c1 = 'A' + 1;    // 'B' (유니코드 66은 'B')
		System.out.println("c1 = " + c1);

	}
}
