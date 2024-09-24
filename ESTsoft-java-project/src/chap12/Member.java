package chap12;

public class Member {
	private String name;
	private String id;

	public Member(String name) {
		System.out.println("매개변수가 하나인 생성자 호출");
		this.name = name;
	}

	public Member(String name, String id) {
		System.out.println("매개변수가 두 개인 생성자 호출");
		this.name = name;
		this.id = id;
	}
}
