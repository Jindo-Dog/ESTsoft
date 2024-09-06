package chap06;

public class Car {    // convention: 첫글자 대문자, 카멜케이스
	String company;        // 멤버 변수, 필드
	String model;
	int maxSpeed;

	public Car() {
		company = "현대자동차";
	}

	//  오버로팅 : 같은 이름의 메소드(생성자)를 여러개 정의하는 것
	Car(String company) {
		this.company = company;
	}

	Car(String company, String model) {
		this.company = company;
		this.model = model;
	}

	Car(String company, String model, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.maxSpeed = maxSpeed;
	}

	public static void main(String[] args) {

		Car car = new Car();    // Car 클래스 객체 생성
		car.setMaxSpeed(200);
		System.out.println(car.printField());

		Car car2 = new Car("기아자동차");
		car2.setMaxSpeed(250);
		System.out.println(car2.printField());

		Car car3 = new Car("현대자동차", "sonata", 300);
		System.out.println("car3 : " + car3);
		System.out.println(car3.printField());

		Car car4 = new Car("페라리", "LaFerrari", 400);
		System.out.println("car4 : " + car4);
		System.out.println(car4.printField());

		car4.setMaxSpeed(60);
		System.out.println(car4.printField());
	}

	void setModel(String model) {
		this.model = model;
	}

	// maxSpeed 값을 넣어주는 메소드
	void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	String printField() {
		return "company: " + company + " , model: " + model + " , maxSpeed: " + maxSpeed;
	}
}
