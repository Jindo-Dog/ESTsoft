package chap11.list;

import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		// ArrayList 값 추가
		List<String> list = new ArrayList<>();    // 기본 메모리 할당 크기 : 10
		list.add("Java");
		list.add("Spring");
		list.add("Servlet/JSP");
		list.add("DBMS");
		list.add("JPA");

		// 총 개수 출력
		System.out.println("총 개수 : " + list.size());

		// 순회하면서 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\t" + i + " : " + list.get(i));
		}

		// 값 삭제
		list.remove(2);
		list.remove(2);

		System.out.println("총 개수 : " + list.size());
		for (String str : list) {
			System.out.println("\t" + str);
		}
	}
}
