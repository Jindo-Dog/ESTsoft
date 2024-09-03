package chap03;

public class BitOperator {
	public static void main(String[] args) {
		int x = 15;
		int y = 30;

		System.out.println(Integer.toBinaryString(x));    // 1111
		System.out.println(Integer.toBinaryString(y));    // 11110

		System.out.println();

		System.out.println(Integer.toBinaryString(x & y));    // 1110
		System.out.println(Integer.toBinaryString(x | y));    // 11111
		System.out.println(Integer.toBinaryString(x ^ y));    // 10001
		System.out.println(Integer.toBinaryString(~x));        // 11111111111111111111111111110000

		System.out.println();

		System.out.println(x & y);    // 14
		System.out.println(x | y);    // 31
		System.out.println(x ^ y);    // 17
		System.out.println(~x);        // -16

		System.out.println();

		System.out.println(8);
		System.out.println(Integer.toBinaryString(8));
		System.out.println(Integer.toBinaryString(-8));

		System.out.println();

		// 비트 쉬프트 연산자
		int value = -8;
		System.out.println(value << 1);    // -16
		System.out.println(value >> 1);    // -4

		System.out.println();

		System.out.println(Integer.toBinaryString(-8 >> 1));
		System.out.println(-8 >> 1);
		System.out.println(Integer.toBinaryString(-8 >>> 1));
		System.out.println(-8 >>> 1);
	}
}
