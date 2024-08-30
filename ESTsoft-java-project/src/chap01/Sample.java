package chap01;

import java.util.HashMap;

public class Sample {
	// double inner = 1.2;
	
	// 클래스 블록
	public static void main(String[] args) {
		// 메소드 블록
		System.out.println("Hello Java");
		
		/* HashMap map = new HashMap();
		map.put("", ""); */
	}
	
	static void variableExample() {
		// int value;
		// int result = value + 10;
		
		int value = 0;
		System.out.println(value);
		
		if(true) {
			double inner = 1.2;
			System.out.println("조건이 참");
			
			for(int i = 0; i < 3; i++) {
				System.out.println(inner);
			}
		}
		// System.out.println(inner);
	}
	
	int getResult() {
		int result = 11;
		return result;
	}
}
