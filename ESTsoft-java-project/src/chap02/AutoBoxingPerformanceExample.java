package chap02;

public class AutoBoxingPerformanceExample {
	public static void main(String[] args) {
		// 성능 측정 (오토박싱 vs 일반)
		long currentTimeMillis = System.currentTimeMillis();
		
		Integer sum1 = 0;
		for(int i = 1; i <= 2000000; i++) {
			sum1 += i;    // 오토박싱
		}
		
		long term = (System.currentTimeMillis() - currentTimeMillis);
		System.out.println("오토박싱 소요 시간: " + term + "ms");
		
		
		currentTimeMillis = System.currentTimeMillis();
		int sum2 = 0;
		for(int i = 1; i <= 2000000; i++) {
			sum2 += i;    // 오토박싱
		}
		
		term = (System.currentTimeMillis() - currentTimeMillis);
		System.out.println("오토박싱 소요 시간: " + term + "ms");
	}
}
