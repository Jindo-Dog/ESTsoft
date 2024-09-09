package chap07.employee;

public class FullTimeEmployee extends Employee {
	double salary;

	FullTimeEmployee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	public double calculateSalary() {
		return salary;
	}
}
