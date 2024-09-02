package chap02.casting;

public class ForceCasting {
	public static void main(String[] args) {
		// long -> int
		long longValue = 300;
		int intValue = (int) longValue;
		System.out.println("intValue = " + intValue);
		
		// double -> int
		double pi = 3.14;
		int convertedInt = (int) pi;
		System.out.println("convertedInt = " + convertedInt);
		
		int intValue2 = 10;
		char charValue = 'A';
		double doubleValue = 5.7;
		String strValue = "A";
		
		// int -> double
		double doubleValue2 = (double) intValue2;
		
		// String -> char (캐스팅으로 변환 불가)
		// char var = (char) strValue;
		
		// 가능하게 하려면 charAt(index) 메소드를 사용해야 함
		char changedValue = strValue.charAt(0);
	}
}
