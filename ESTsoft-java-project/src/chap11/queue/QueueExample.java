package chap11.queue;

import java.util.*;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		messageQueue.offer(new Message("sendKakaoTalk", "제니"));
		messageQueue.offer(new Message("sendMail", "리사"));
		messageQueue.offer(new Message("sendSms", "로제"));

		// switch-case문을 이용해서 특정 command일 경우 출력문 다르게

		// for문 사용
		/*for (Message message : messageQueue) {
			switch (message.getCommand()) {
				case "sendKakaoTalk" -> System.out.println(message.getTo() + "님에게 카카오톡을 보냅니다.");
				case "sendMail" -> System.out.println(message.getTo() + "님에게 메일을 보냅니다.");
				case "sendSms" -> System.out.println(message.getTo() + "님에게 SMS를 보냅니다.");
			}
		}*/

		// while문 사용
		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.getCommand()) {
				case "sendKakaoTalk" -> System.out.println(message.getTo() + "님에게 카카오톡을 보냅니다.");
				case "sendMail" -> System.out.println(message.getTo() + "님에게 메일을 보냅니다.");
				case "sendSms" -> System.out.println(message.getTo() + "님에게 SMS를 보냅니다.");
			}
		}
	}
}
