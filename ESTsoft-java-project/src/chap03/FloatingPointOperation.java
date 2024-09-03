package chap03;

public class FloatingPointOperation {
	public static void main(String[] args) {
		// float의 비트 구조 : 부호(1) + 지수(8) + 가수(23)
		// int의 비트 구조 : 부호(1) + 절대값(31)
		// int를 float으로 변환할 때, int의 비트 구조를 그대로 가져와서 float의 비트 구조에 맞추어 변환한다.
		// 따라서 int를 float으로 변환할 때, 8비트가 손실된다.

		int myInt = 16777217;  // 2^24 + 1
		float myFloat = (float)myInt;

		System.out.println("myInt: " + myInt);  // 출력: 16777217
		System.out.println("myFloat: " + myFloat);  // 출력: 16777216.0

		System.out.println(myInt == myFloat);    // MyInt가 float으로 변환되어 손실 발생. 따라서 true
	}
}
