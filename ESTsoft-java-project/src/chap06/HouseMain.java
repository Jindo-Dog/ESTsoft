package chap06;

import chap06.house.HouseKim;

public class HouseMain {
	public static void main(String[] args) {
		HouseKim kim = new HouseKim();
		// System.out.println(kim.lastname);	// lastname은 default 접근제어자로 설정되어 외부 패키지에서 접근 불가
	}
}
