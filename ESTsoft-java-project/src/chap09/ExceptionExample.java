package chap09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample {
	public static void main(String[] args) {
		int b = Integer.parseInt(args[0]);
		int result = 10 / b;    // 예외 발생 가능성이 있는 코드 (예외 처리 필요)

		// (존재하는)파일에서 데이터를 읽어오는 코드 (예외 상황을 가정해서 예외 처리를 해야 함)
		/*BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
		reader.readLine();
		reader.close();*/

		try {
			BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
			reader.readLine();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}
}
