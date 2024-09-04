package chap04;

public class ForContinueLoop {
	public static void main(String[] args) {
		for (int i = 0; i <= 60; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println(i);
			}
		}
	}
}
