package chap07;

public class Dog extends Animal {
	Dog() {
		// super();    // 부모 클래스의 생성자가 자동으로 호출됨
		System.out.println("Dog 객체 생성");
	}

	Dog(String name) {
		// super();    // 부모 클래스의 생성자가 자동으로 호출됨
		System.out.println("Dog 객체 생성, 이름: " + name);
		this.name = name;
	}

	/*@Override
	public void sleep() {
		// 부모 클래스의 sleep() 메소드 오버라이딩
	}*/

	public void sleep(int times) {    // OverLoading
		System.out.println(name + " Zzz... " + times + " hours");
	}
}
