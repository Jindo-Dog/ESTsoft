package chap08.defaultmethod;

public class Zoo {
	public static void main(String[] args) {
		Zookeeper zookeeper = new Zookeeper();

		Lion lion = new Lion();
		// Predator lion = new Lion();
		zookeeper.feed(lion);

		Tiger tiger = new Tiger();
		// Predator tiger = new Tiger();
		zookeeper.feed(tiger);
	}
}
