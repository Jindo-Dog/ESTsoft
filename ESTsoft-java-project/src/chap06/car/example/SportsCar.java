package chap06.car.example;

import chap06.car.Car;

public class SportsCar extends Car {
	public static void main(String[] args) {
		SportsCar sportsCar = new SportsCar();
		System.out.println(sportsCar.company);    // protected 필드 접근 가능
		// sportsCar.model;	// private 필드 접근 불가
	}
}
