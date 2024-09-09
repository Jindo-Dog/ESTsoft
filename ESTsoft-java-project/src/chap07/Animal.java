package chap07;

public class Animal {
	String name;

	Animal() {
		System.out.println("Animal 객체 생성");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sleep() {
		System.out.println(name + " Zzz...");
	}
}
