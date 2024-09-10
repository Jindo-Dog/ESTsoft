package chap08.defaultmethod;

public interface Predator {
	String getFood();

	default void printFood() {
		System.out.printf("my food is %s\n", getFood());
	}
}
