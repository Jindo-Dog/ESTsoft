package chap03;

public class Sample2 {
	public static void main(String[] args) {
		int x1 = 51;
		double x2 = 50.34;

		int result1 = (int)(x1 - x2);
		int result2 = x1 - (int)x2;
		System.out.println(result1);
		System.out.println(result2);
	}
}
