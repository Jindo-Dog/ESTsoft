package chap02;

public class VariableExample {
	public static void main(String[] args) {
		// long 타입
		int a = 1;
		// int b = 10000000000;		// integer number too large
		// int b = 10000000000L;	// incompatible types: possible lossy conversion from long to int
		
		long longValue = 100;                // (int -> long 변환)
		long longValue2 = 10000000000L;        // 100억
		
		// float 타입
		// float floatValue = 1.01234;
		float floatValue = 1.01234F;
		double doubleValue = 1.01234;
		
		System.out.println("floatValue = " + floatValue);
		System.out.println("doubleValue = " + doubleValue);
		
		float floatValue2 = 1.234567890123456789F;
		double doubleValue2 = 1.234567890123456789;
		
		System.out.println("floatValue2 = " + floatValue2);
		System.out.println("doubleValue2 = " + doubleValue2);
	}
}
