package chap11.queue;

public class Message {
	private String command;        // sendMail, sendKakaotalk, SendSms
	private String to;            // 수신신

	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}

	public String getCommand() {
		return command;
	}

	public String getTo() {
		return to;
	}
}
