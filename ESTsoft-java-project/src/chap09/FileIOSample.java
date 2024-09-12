package chap09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * divide 연산 & 파일 내용 읽어오는 코드
 * 예외 발생 가능성
 * - ArithmeticException
 * - FileNotFoundException
 * - IOException
 */
public class FileIOSample {
	public static void main(String[] args) {
		// 파일 내용 읽어오는 코드
		int b = Integer.parseInt(args[0]);
		// int b = 10;
		int result = 5 / b;        // ArithmeticException 발생 가능성이 있는 코드
		System.out.println(result);

		// 작업 디렉토리를 기준으로 경로를 찾는 방법
		String file = System.getProperty("user.dir");
		String filename = file + "/src/chap09/file1.txt";

		// 컴파일된 파일을 기준으로 경로를 찾는 방법
		// String path = FileIOSample.class.getResource("").getPath();

		// try-with-resources 구문 (자동 리소스 닫기)
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

			// BufferedReader reader = new BufferedReader(new FileReader(filename));
			// BufferedReader reader = new BufferedReader(new FileReader(path + "file2.txt"));

			System.out.println(reader.readLine());
			// reader.close();
		} catch (FileNotFoundException | ArithmeticException e) {
			System.out.println("Exception 발생");    // 예외 처리 구문이 같은 경우 함께 처리 가능
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException 발생");
			System.out.println(e.getMessage());
		} /*catch (FileNotFoundException e){
			// FileNotFoundException은 IOException의 하위 클래스이므로 이미 처리된 예외이므로 컴파일 에러 발생
		}*/ finally {
			// 예외가 발생해도 실행되는 코드
			System.out.println("무조건 실행");
		}
	}
}
