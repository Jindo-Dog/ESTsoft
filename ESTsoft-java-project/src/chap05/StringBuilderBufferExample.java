package chap05;

public class StringBuilderBufferExample {
	public static void main(String[] args) {
		String result = "";
		result += "Hello ";
		result += "Java ";
		result += "World!";
		System.out.println(result);

		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello ");
		buffer.append("Java ");
		buffer.append("World!");
		System.out.println(buffer);

		StringBuilder builder = new StringBuilder();
		builder.append("Hello ");
		builder.append("Java ");
		builder.append("World!");
		System.out.println(builder);

		// insert()
		System.out.println(builder.insert(0, "첫번째"));
		// builder.insert(50, "오십번째");		// java.lang.StringIndexOutOfBoundsException
		System.out.println(builder.insert(builder.length(), "마지막"));

		// substring()
		String substringResult1 = buffer.substring(6);
		String substringResult2 = buffer.substring(6, 7);

		System.out.println(substringResult1);
		System.out.println(substringResult2);

		// 문자열 압축하기
		String str = "aaaabbccd";
		StringBuilder compressedStr = new StringBuilder();
		char temp = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (temp == str.charAt(i)) {
				count++;
			} else {
				compressedStr.append(temp);
				compressedStr.append(count);
				temp = str.charAt(i);
				count = 1;
			}
		}
		System.out.println(compressedStr);
	}
}
