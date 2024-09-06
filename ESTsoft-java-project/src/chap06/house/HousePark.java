package chap06.house;

public class HousePark {
	String lastname = "park";

	public static void main(String[] args) {
		HouseKim kim = new HouseKim();
		System.out.println(kim.lastname);    // lastname은 default 접근제어자로 설정되어 같은 패키지에서 접근 가능
	}
}
