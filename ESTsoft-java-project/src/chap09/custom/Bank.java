package chap09.custom;

public class Bank {
	public static void main(String[] args) {
		Account account = new Account(30000);

		try {
			account.deposit(40000);
			account.withdraw(100000);
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
