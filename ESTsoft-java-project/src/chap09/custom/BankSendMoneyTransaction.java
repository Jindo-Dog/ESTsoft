package chap09.custom;

/**
 * '송금' 트랜잭션
 */
public class BankSendMoneyTransaction {
	public static void main(String[] args) {
		// A, B 계좌 생성
		Account accountA = new Account(10000);
		Account accountB = new Account(0);

		// A -> B 10만원 송금
		// 만약 잔약보다 큰 금액을 송금할 경우 트랜잭션 처리
		int money = 100_000;
		try {
			accountB.deposit(money);    // B 계좌로 입금
			accountA.withdraw(money);    // A 계좌에서 출금
			System.out.println("송금 성공");
		} catch (BalanceInsufficientException e) {
			// A 계좌 출금 실패 시, B 계좌에 입금한 금액을 롤백
			System.out.println(e.getMessage());
			accountB.depositRollback(money);
			System.out.println("송금 실패");
		} catch (DepositException e) {
			System.out.println("입금 실패에 대한 처리");
		}
	}
}
