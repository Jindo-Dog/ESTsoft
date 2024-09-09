package chap07.employee2;

public abstract class Employee {
	String name;

	Employee(String name) {
		this.name = name;
	}

	protected abstract double calculateSalary();

	public String getName() {
		return name;
	}
}
