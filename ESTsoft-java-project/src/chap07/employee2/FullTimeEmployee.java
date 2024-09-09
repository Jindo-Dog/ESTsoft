package chap07.employee2;

public class FullTimeEmployee extends Employee {
	double salary;

	FullTimeEmployee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	protected double calculateSalary() {
		return salary;
	}
}
