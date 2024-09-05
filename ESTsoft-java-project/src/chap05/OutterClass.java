package chap05;

public class OutterClass {
	public static void main(String[] args) {
		System.out.println(ClassInstanceVariable.classVar);        // 클래스 변수 접근

		// ClassInstanceVariable.instanceVar	// 인스턴스 변수 접근 불가
		ClassInstanceVariable object = new ClassInstanceVariable();
		System.out.println(object.instanceVar);    // 인스턴스 변수 접근
	}
}
