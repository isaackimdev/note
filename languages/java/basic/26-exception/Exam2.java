
public class Exam2 {

	public static void main(String[] args) {
		int[] arr = new int[3];
		try {
			for(int i=0; i<5; i++) {
				arr[i] = i;
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			System.out.println("에러가 발생했습니다.");
			System.out.println("원인 : " + e.getMessage());
		}
		
		System.out.println("--- 프로그램을 종료합니다. ---");
		
	}
}

