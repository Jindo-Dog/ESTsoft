package chap09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceSample {
	public static void main(String[] args) {
		// file을 읽어오는 로직
		String file = System.getProperty("user.dir");
		String filename = file + "/src/chap09/file1.txt";

		/*BufferedReader reader = null;
		try {
			// 에러 발생 시 뒤의 코드는 실행되지 않음
			reader = new BufferedReader(new FileReader(filename));
			reader.readLine();
			reader.close();
		} catch (IOException e) {
			System.out.println("IOException 발생");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("reader close 실패");
					try {
						reader.close();
					} catch (IOException e1) {
						System.out.println("reader close 실패");
					} finally {
						// 결국은 finally로 close를 해야할 수도 있음
						// try-catch가 계속 반복될 수 있음
						// 실제로 닫혔는지 보장할 수도 없다
					}
				}
			}
		}*/

		// AutoClosable 인터페이스를 구현한 클래스만 try-with-resources 구문을 사용할 수 있다
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			reader.readLine();
			// reader.close();	// 자동으로 호출되는 코드
		} catch (IOException e) {
			System.out.println("IOException 발생");
		}
	}
}
