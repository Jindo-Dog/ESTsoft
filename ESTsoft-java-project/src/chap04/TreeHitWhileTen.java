package chap04;

public class TreeHitWhileTen {
	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			i++;
			System.out.println("나무를 " + i + "번 찍었습니다.");
			if (i == 10) {
				System.out.println("나무 넘어갑니다.");
			}
		}
	}
}
