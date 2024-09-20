package chap11.set;

import java.util.*;

import chap10.wildcard.Person;

public class HashSetExample {
	public static void main(String[] args) {
		// 1. 값 추가
		Set<String> hashSet = new HashSet<>();
		hashSet.add("카리나");
		hashSet.add("윈터");
		hashSet.add("카리나");

		// 2. 값 검색 (개수, 각 요소)
		System.out.println("총 개수: " + hashSet.size());

		// for (int i = 0; i < hashSet.size(); i++) {	// Set은 인덱스로 접근 불가
		for (String str : hashSet) {
			System.out.println("\t" + str);
		}

		System.out.println("--------------------");

		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
			iterator.remove();
		}

		System.out.println("--------------------");

		// 3. 값 삭제
		/*hashSet.remove("카리나");
		hashSet.clear();*/

		if (hashSet.isEmpty()) {
			System.out.println("비어있음" + hashSet);
		}

		Person person1 = new Person("이름");
		Person person2 = new Person("이름");

		/*System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		System.out.println("카리나".hashCode());
		System.out.println("카리나".hashCode());*/

		Set<Person> set = new HashSet<>();
		set.add(person1);
		set.add(person2);
		System.out.println(set.size());        // Person 안의 메소드 오버라이딩을 통해 동일한 객체로 판단

		Member member1 = new Member("홍길동", 30);
		Member member2 = new Member("홍길동", 30);
		Set<Member> memberSet = new HashSet<>();
		memberSet.add(member1);
		memberSet.add(member2);
		System.out.println(memberSet.size());    // name, age가 같은 경우 동일한 객체로 취급
	}
}
