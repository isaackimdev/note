
public class Exam3 {

	public static void main(String[] args) {
		// 1~10까지의 합
		int sum = 0;
		int x=1;	// 초기값 (for문)
		
		while (x <=10) {		// 조건식 (for문)
			sum += x;
			x++;				// 증감식 (for문)
		}
		System.out.println("sum="+sum);
		///////////////////////////////////////////////
		sum = 0;
		x = 1;
		while(true) {
			
			sum += x;
			if (x >= 10) break;
			x++;
		
		}
		
		System.out.println("sum="+sum);
		///////////////////////////////////////////////		
		sum=0;
		for (x=1; x<=10; x++) {
			sum += x;
		}
		System.out.println("sum="+sum);
		
		
		
	}	

}
