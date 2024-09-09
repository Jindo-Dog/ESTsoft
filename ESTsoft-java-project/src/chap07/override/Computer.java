package chap07.override;

public class Computer extends Calculator {
	@Override
	double areaCircle(double r) {
		return Math.PI * r * r;
	}
}
