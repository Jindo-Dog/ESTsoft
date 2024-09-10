package chap08.zoo2;

public class Zookeeper {
	void feed(Predator predator) {
		// System.out.println("feed meat");
		System.out.println("feed " + predator.getFood());    // 다형성
	}
}
