package chap07.abstact;

public class PhoneExample {
	public static void main(String[] args) {
		// 추상 클래스 생성자로 객체 생성 불가
		// Phone phone = new Phone();

		SmartPhone smartPhone = new SmartPhone("홍길동");

		smartPhone.turnOn();   // Phone의 메소드
		smartPhone.internetSearch();
		smartPhone.turnOff();  // Phone의 메소드

		SmartPhone smartPhone2 = new SmartPhone("owner");
		SmartPhone smartPhone3 = new SmartPhone("");

		// 추상 클래스, 인터페이스의 다형성
		Phone[] list = {smartPhone, smartPhone2, smartPhone3};
	}
}