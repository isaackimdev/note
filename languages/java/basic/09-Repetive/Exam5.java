
public class Exam5 {

	public static void main(String[] args) {
		int sum = 0;
		int x = 1 ;      // 초기값
		
		do {
			
			sum +=x;
			x++;		// 증감식
			
		} while (x<=10);	// 조건식
		
		System.out.println("sum="+sum);
	}

}
