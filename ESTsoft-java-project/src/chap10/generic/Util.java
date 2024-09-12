package chap10.generic;

public class Util {
	// public static <T, E> Box<T> boxing(T t, E e) {	// 더 추가하고 싶으면 나열하면 됨
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.set(t);
		return box;
	}
}
