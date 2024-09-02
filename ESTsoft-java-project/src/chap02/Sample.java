package chap02;

public class Sample {
	public static void main(String[] args) {
		// 참조 자료형 : new 예약어를 사용하여 변수를 초기화
		// String은 예외
		
		String str = "";    // 포기화
		
		String str1 = "실제값";
		String str2 = new String("실제값");
		String str3 = "실제값";
		String str4 = new String("실제값");
		
		System.out.println(str1 == str2);    // false
		System.out.println(str1 == str3);    // true
		System.out.println(str2 == str3);    // false
		System.out.println(str2 == str4);    // false
		System.out.println(str3 == str4);    // false
		
		// String str = null;    // null
		// str.length();        // NullPointerException
		
		Integer integerValue = 0;
		integerValue.longValue();
		
		int index1 = 11;
		Integer number1 = Integer.valueOf(index1);  // 박싱(Boxing)
		
		int index2 = 11;
		Integer number2 = index2;   // 오토박싱(Auto Boxing)
		
		Long.valueOf(10L);
		Float.valueOf(3.14F);
		Double.valueOf(3.14);
	}
}
