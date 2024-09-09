package chap07.employee;

public class PartTimeEmployee extends Employee {
	double hourlyRate;
	int hoursWorked;

	PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
		super(name);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}
