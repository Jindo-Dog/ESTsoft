package chap07.abstact;

public class SmartPhone extends Phone {
	// 생성자
	public SmartPhone(String owner) {
		super(owner);
	}

	// 메소드
	// internetSearch 메소드가 없다면 컴파이 ㄹ오류 발생
	@Override
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}