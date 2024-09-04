package chap04;

public class WhileLoop {
	public static void main(String[] args) {
		int index = 0;
		while (index <= 5) {
			System.out.println(index);
			index++;
		}

		System.out.println("--------------------");

		// while문으로 0~60까지 숫자 중 3의 배수 출력하기(continue문 사용)
		int i = 0;
		while (i <= 60) {
			i++;
			if (i % 3 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
