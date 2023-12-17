// Runable interface 를 Anonymus class 로...

public class Exam4 {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("TEST thread 4");
			}
		}).start();
		// for문이 동작되어 지다가 thread 의 run이 동작하게 됨.
		// main과 독립적으로 구동. 통신 >> "응답"  : 클라이언트는 응답쪽에서 시간이 오래 걸려서 '웅답'에 사용
							// 서버에서는 "요청" 에서 쓰레드를 사용
		for(int i =  0  ; i < 500 ; i++ ) {
			System.out.println(i);
		}
		
		
	}

}
