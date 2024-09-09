package chap07.employee2;

public class PartTimeEmployee extends Employee {
	double hourlyRate;
	int hoursWorked;

	PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
		super(name);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	protected double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}
