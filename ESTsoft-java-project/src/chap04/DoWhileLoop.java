package chap04;

public class DoWhileLoop {
	public static void main(String[] args) {
		// do-while문으로 0~60까지 숫자 중 3의 배수 출력하기
		int i = 0;
		do {
			i++;
			if (i % 3 == 0) {
				System.out.println(i);
			}
		} while (i <= 60);
	}
}
