package chap11.map;

import java.util.*;

public class HashMapExample {
	public static void main(String[] args) {
		// 1. map 객체 선언, key 값 추가
		Map<String, Integer> hashmap = new HashMap<>();
		hashmap.put("홍길동", 10);
		hashmap.put("윈터", 20);
		hashmap.put("윈터", 30);

		System.out.println(hashmap.get("key"));    // null
		hashmap.getOrDefault("key", 0);    // 0

		System.out.println("총 개수: " + hashmap.size());

		// 2. 각 key, value를 순회하면서 출력 -> keySet()
		Set<String> keySet = hashmap.keySet();
		for (String key : keySet) {
			System.out.println("\t" + key + " : " + hashmap.get(key));
		}

		System.out.println("--------------------");

		// 3. 각 key, value를 순회하면서 출력 -> entrySet()
		Set<Map.Entry<String, Integer>> entrySet = hashmap.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println("\t" + entry.getKey() + " : " + entry.getValue());
		}
	}
}
