class ThreadExam2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Test thread 2");
	}
	
}

public class Exam2 {
	public static void main(String[] args) {
		// Runnable 按眉 积己
		ThreadExam2 threadExam2 = new ThreadExam2();
		// Thread 按眉 积己
		Thread thread = new Thread(threadExam2);
		// Thread 角青
		thread.start();
		for(int i =  0  ; i < 500 ; i++ ) {
			System.out.println(i);
		}
		
	}
}
