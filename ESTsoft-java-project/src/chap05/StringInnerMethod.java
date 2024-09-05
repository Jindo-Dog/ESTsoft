package chap05;

public class StringInnerMethod {
	public static void main(String[] args) {
		String hello = "Hello Java";
		int index = hello.indexOf('J');
		System.out.println(index);    // 6

		char ch = hello.charAt(index);
		System.out.println(ch);    // J

		// replaceAll()
		String hello2 = "Hello Java Java";
		String replaceStr = hello2.replaceAll("Java", "everyone");
		System.out.println(replaceStr);    // Hello everyone everyone

		// substring()
		String hello3 = "Hello everyone everyone";
		String substringStr = hello3.substring(8, 13);
		System.out.println(substringStr);    // eryone
		System.out.println(hello3.substring(8));    // eryone everyone

		// toUpperCase(), toLowerCase()
		String hello4 = "Hello World!";
		System.out.println(hello4.toUpperCase());    // HELLO WORLD!
		System.out.println(hello4.toLowerCase());    // hello world!

		// trim()
		String hello5 = "   Hello World!   ";
		System.out.println(hello5.trim());    // Hello World!

		System.out.println("--------------------");

		String str = "aaaabbccd";
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

		String str2 = "Hello Welcome Java";
		String[] strArr = str2.split(" ");
		for (int i = strArr.length; i > 0; i--) {
			System.out.print(strArr[i - 1] + " ");
		}

		System.out.println();

		String str3 = "   Hello Welcome Java   ";
		System.out.println(str3.replaceAll(" ", ""));
	}
}
