package chap08.payment;

public class PaymentProcess {
	public static void main(String[] args) {
		CreditCard creditCardPayment = new CreditCard("1234-5678-9012-3456");
		Paypal payPalPayment = new Paypal("email@aws.com");

		creditCardPayment.processPayment(67000);
		payPalPayment.processPayment(67000);

		// 다형성. 인터페이스 타입으로 선언 가능
		Payment payment1 = new CreditCard("1234-5678-9012-3456");
		Payment payment2 = new Paypal("email@aws.com");

		payment1.processPayment(67000);
		payment2.processPayment(67000);
	}
}
