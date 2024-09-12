package chap09;

public class TryWithResourceSample2 {
	public static void main(String[] args) {
		try (FileStream stream = new FileStream("file.txt")) {
			stream.read();
			stream.write();
		} catch (Exception e) {
			System.out.println("예외 처리 코드가 실행되었습니다.");
			System.out.println(e.getMessage());
		}
	}
}
