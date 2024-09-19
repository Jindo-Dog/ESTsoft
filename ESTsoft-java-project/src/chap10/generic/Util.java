package chap10.generic;

public class Util {
	// 프로젝트 전역에서 사용할 변수나 함수를 Util 클래스에서 정의해서 사용한다
	public static final double PI = 3.141592;    // Util.PI

	/**
	 * 제네릭 메소드 선언
	 */
	// public static <T, E> Box<T> boxing(T t, E e) {	// 더 추가하고 싶으면 나열하면 됨
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.set(t);
		return box;
	}
}
