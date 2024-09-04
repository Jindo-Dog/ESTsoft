package chap04;

public class DaySwitchCaseExample {
	public static void main(String[] args) {
		System.out.println(
			switch (args[0]) {
				case "월요일" -> "Start of the work week";
				case "금요일" -> "Almost weekend";
				default -> "Midweek";
			}
		);
	}
}
