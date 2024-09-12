package chap10;

public class BoxExample {
	public static void main(String[] args) {
		Box box = new Box();
		box.set("문자열");

		String str = (String)box.get();
		System.out.println(str);
	}
}
