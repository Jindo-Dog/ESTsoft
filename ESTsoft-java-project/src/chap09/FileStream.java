package chap09;

public class FileStream implements AutoCloseable {
	private String fileName;

	public FileStream(String fileName) {
		this.fileName = fileName;
	}

	public void read() throws Exception {
		System.out.println(fileName + "을 읽습니다.");
		throw new Exception("예외 발생 상황 가정");
	}

	public void write() {
		System.out.println(fileName + "을 씁니다.");
	}

	@Override
	public void close() throws Exception {
		System.out.println(fileName + "을 닫습니다.");
	}
}
