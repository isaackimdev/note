// 시간이 많이 걸릴 것 같은 코드를 독립적으로 구동 하는 것 : Thread
// 쓰레드를 사용하는 방법
// 1. thread 상속 받기
class ThreadExam1 extends Thread {
	@Override
	//2. run 이라는 함수를 Override
	public void run() {
			System.out.println("Test thread 1 ");
	}
}

public class Exam1 {

	public static void main(String[] args) {
		// Thread 객체 생성
		ThreadExam1 threadExam1 = new ThreadExam1();
		// Thread 실행
		System.out.println("Test thread 2 ");
		threadExam1.start();		// 쓰레드로 구동시키기 main 과 독립적으로 따로 구동, 준비기간이 있음.
		//threadExam1.run();		// 일반 함수 사용법 : 쓰레드 구동이 아님   ,,독립된 형태가 아니라 구속되어 있음
		for(int i =  0  ; i < 500 ; i++ ) {
			System.out.println(i);
		}
		System.out.println("Test thread 3 ");
	}
}
