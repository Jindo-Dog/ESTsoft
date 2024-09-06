package chap06;

public class Person {
	final String nation;
	String name;

	Person(String name) {
		this.nation = "Korea";    // final 변수는 생성자에서 초기화 가능
		this.name = name;
	}
}
