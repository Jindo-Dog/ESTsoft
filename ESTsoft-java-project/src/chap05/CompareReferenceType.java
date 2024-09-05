package chap05;

public class CompareReferenceType {
	public static void main(String[] args) {
		OutterClass outter1 = new OutterClass();
		OutterClass outter2 = new OutterClass();

		System.out.println("outter == outter2 결과: " + (outter1 == outter2));    // 서로 다른 객체

		String str1 = new String("문자1");
		String str2 = new String("문자1");
		System.out.println("str1 == str2 결과: " + (str1 == str2));    // 서로 다른 객체

		String str3 = "문자1";
		System.out.println("str1 == str3 결과: " + (str1 == str3));    // 서로 다른 객체
		String str4 = "문자1";
		System.out.println("str3 == str4 결과: " + (str3 == str4));    // 같은 객체

		System.out.print("값만 비교해서 출력: ");
		System.out.print(str1.equals(str2) + "/");    // 같은 문자열
		System.out.print(str1.equals(str3) + "/");    // 같은 문자열
		System.out.println(str3.equals(str4));    // 같은 문자열
	}
}
