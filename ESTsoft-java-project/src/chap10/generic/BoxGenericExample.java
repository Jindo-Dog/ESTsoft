package chap10.generic;

public class BoxGenericExample {
	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.set("문자열");
		// box.set(10);    // 다른 타입값은 입력 불가(컴파일 오류 발생)
		String str = box.get();
		System.out.println(str);

		Box<Integer> intBox = new Box<>();
		Box<Double> doubleBox = new Box<>();
		Box<Boolean> booleanBox = new Box<>();

		// 제네릭 메소드
		Box<String> value = Util.boxing("문자열값");
		System.out.println(value.get());

		Box<Integer> value2 = Util.boxing(100);
		System.out.println(value2.get());

		Box<Double> value3 = Util.boxing(567.89);
		System.out.println(value3.get());
	}
}
