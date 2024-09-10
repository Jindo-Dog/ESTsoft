package chap08.vehicle;

public class Driver {
	void drive(Vehicle vehicle) {
		// instanceof 연산자
		/*if (vehicle instanceof Bus) {
			System.out.println("Bus//");
		} else if (vehicle instanceof Taxi) {
			System.out.println("Taxi//");
		}*/

		// switch-case문
		// Pattern Matching for switch (JDK 17부터 사용 가능)
		switch (vehicle) {
			case Bus bus -> System.out.println("Bus");
			case Taxi taxi -> System.out.println("Taxi");
			default -> System.out.println("Unknown");
		}

		vehicle.run();
	}
}
