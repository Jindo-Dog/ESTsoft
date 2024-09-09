package chap07.override;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();

		child.method1();
		child.method2();    // 재정의된 메소드 호출
		child.method3();

		Parent parent = new Parent();
		parent.method1();
		parent.method2();
	}
}