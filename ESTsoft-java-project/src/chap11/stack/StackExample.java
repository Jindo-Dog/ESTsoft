package chap11.stack;

import java.util.*;

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinStack = new Stack<>();

		coinStack.push(new Coin(500));
		coinStack.push(new Coin(100));
		coinStack.push(new Coin(50));
		coinStack.push(new Coin(10));

		while (!coinStack.isEmpty()) {   // 동전케이스가 비었다면 반복문 종료
			// Coin coin = coinStack.pop();    // Coin 객체로 꺼내기
			System.out.println("꺼내온 동전: " + coinStack.pop().getValue() + "원");    // 동전케이스에서 제일 위에 동전 꺼내기
		}
	}
}
