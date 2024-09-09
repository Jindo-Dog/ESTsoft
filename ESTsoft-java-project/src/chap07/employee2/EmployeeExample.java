package chap07.employee2;

import chap07.employee2.Employee;

public class EmployeeExample {
	public static void main(String[] args) {
		// 객체 생성
		FullTimeEmployee alice = new FullTimeEmployee("Alice", 50000000);
		PartTimeEmployee bob = new PartTimeEmployee("Bob", 10000, 8);

		// 출력(객체 내부 요소 호출)
		System.out.println(alice.getName() + "'s Salary: " + alice.calculateSalary());
		System.out.println(bob.getName() + "'s Salary: " + bob.calculateSalary());

		// Employee employee = new Employee("Charlie");    // 'Employee'는 abstract이며, 인스턴스화할 수 없습니다.

		// 다형성
		Employee fullTimeEmployee = new FullTimeEmployee("David", 50000000);    // 업캐스팅
		Employee partTimeEmployee = new PartTimeEmployee("Eve", 10000, 8);    // 업캐스팅
		System.out.println(fullTimeEmployee.getName() + "'s Salary: " + fullTimeEmployee.calculateSalary());
		System.out.println(partTimeEmployee.getName() + "'s Salary: " + partTimeEmployee.calculateSalary());
	}
}

