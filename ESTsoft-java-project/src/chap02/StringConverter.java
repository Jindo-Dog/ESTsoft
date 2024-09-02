package chap02;

public class StringConverter {
	public static void main(String[] args) {
		// String -> int/Integer
		String str = "12345";    // int / Integer
		// String str = "1234ab5";		// NumberFormatException
		int primitiveStr = Integer.parseInt(str);
		Integer wrapperStr = Integer.valueOf(str);
		System.out.println("primitiveStr = " + primitiveStr);
		System.out.println("wrapperStr = " + wrapperStr);
		
		// String -> long/Long
		long primitiveLong = Long.parseLong(str);
		Long wrapperLong = Long.valueOf(str);
		System.out.println("primitiveLong = " + primitiveLong);
		System.out.println("wrapperLong = " + wrapperLong);
		
		// String -> float/Float
		String str2 = "3.14159";
		float primitiveFloat = Float.parseFloat(str2);
		Float wrapperFloat = Float.valueOf(str2);
		System.out.println("primitiveFloat = " + primitiveFloat);
		System.out.println("wrapperFloat = " + wrapperFloat);
		
		// String -> double/Double
		double primitiveDouble = Double.parseDouble(str2);
		Double wrapperDouble = Double.valueOf(str2);
		System.out.println("primitiveDouble = " + primitiveDouble);
		System.out.println("wrapperDouble = " + wrapperDouble);
		
		// int -> String
		int intValue = 10;
		String s1 = intValue + "";
		String s2 = Integer.toString(intValue);
		String s3 = String.valueOf(intValue);
		System.out.println("intValue = " + intValue);
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
	}
}
