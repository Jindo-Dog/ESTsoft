package chap06;

public class DefaultConstructor {
	String field;

	DefaultConstructor() {
		this.field = "특정값으로 초기화";
	}

	DefaultConstructor(String field) {
		this.field = field;
	}

	public static void main(String[] args) {
		// 입력값 없는 생성자
		DefaultConstructor c2 = new DefaultConstructor();

		// 입력값 있는 생성자
		DefaultConstructor constructorTest = new DefaultConstructor("특정값");

	}
}
