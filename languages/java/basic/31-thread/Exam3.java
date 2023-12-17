// Anonymous class

public class Exam3 {
	public static void main(String[] args) {	// 익명클래스의 방법
		
		new Thread() {	// 쓰레드는 속도가 살짝 늦추어져서 독립적으로 실행됨, 준비기간이 있다보니...
			public void run() {
				System.out.println("Test thread 3");
			}
		}.start();
		
		for(int i =  0  ; i < 500 ; i++ ) {
			System.out.println(i);
		}
	}
}
