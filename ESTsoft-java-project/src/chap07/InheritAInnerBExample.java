package chap07;

public class InheritAInnerBExample {
	public static void main(String[] args) {
		InheritB inheritB = new InheritB();

		inheritB.field1 = 10;
		inheritB.method1();        // 부모 클래스의 구성요소

		inheritB.field2 = 20;
		inheritB.method2();        // 자식 클래스의 구성요소
	}
}
