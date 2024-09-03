package chap01;

public class GarbageValueExample {
	public static void main(String[] args) {
		byte a = 125;    // -128 ~ 127
		int b = 125;    // -2,147,483,648 ~ 2,147,483,647

		for (int i = 0; i < 5; i++) {
			a++;
			b++;
			System.out.println("a: " + a + ", b: " + b);
		}

		// 문자
		char ch = 'C';

		// 문자열
		String str = "값을 표현할 수 있습니다.";
	}
}
