package chap07.employee;

public class EmployeeExample {
	public static void main(String[] args) {
		// 객체 생성
		FullTimeEmployee alice = new FullTimeEmployee("Alice", 50000000);
		PartTimeEmployee bob = new PartTimeEmployee("Bob", 10000, 8);

		// 출력(객체 내부 요소 호출)
		System.out.println(alice.getName() + "'s Salary: " + alice.calculateSalary());
		System.out.println(bob.getName() + "'s Salary: " + bob.calculateSalary());
	}
}

