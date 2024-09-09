package chap07;

public class Student extends Person {
	int studentNo;

	// Student()
	// super() 호출
	// Person 클래스에 Person() 생성자가 없으므로 컴파일 에러

	Student(String name, String ssn, int studentNo) {
		// this.studentNo = studentNo;		// 상위 타입 생성자가 호출되기 전에 this를 참조할 수 없음
		super(name, ssn);
		this.studentNo = studentNo;
	}
}
