package chap06;

public class Animal {
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
}
