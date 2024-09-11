package chap09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * throws와 throw 사용해보기
 * throws : 메소드의 선언문에서 해댱메소드가 처리하지 않은 예외를 호출자에게 전달하는 목적
 * throw : 메소드 내에서 예외를 발생시키는 데 사용
 */
public class FileIOSample2 {
	public static void main(String[] args) {
		FileIOSample2 fileIOSample2 = new FileIOSample2();

		try {
			fileIOSample2.readFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// fileIOSample2.readFile2();

		// fileIOSample2.handleFile();	// throws를 계속 전파하는 것은 좋지 않다
	}

	public void readFile() throws IOException {    // throws를 사용하면 예외를 호출한 곳으로 전파한다. 호출하는 측에서 예외를 결국 처리해야 함
		BufferedReader reader = new BufferedReader(new FileReader("없는파일.txt"));
		System.out.println(reader.readLine());
		reader.close();
	}

	public void readFile2() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(""));
			System.out.println(reader.readLine());
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void handleFile() throws IOException {
		readFile();
	}
}
