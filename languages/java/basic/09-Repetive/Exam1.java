// < 실행 결과 >
// 1050-735=315

public class Exam1 {

	public static void main(String[] args) {
		double b=0, c=0;
		for(long a=1; a<=10000000000L; a++) {
			if(a%5 == 0 ) b += a;
			if(a%7 == 0 ) c += a;
		}
		
		System.out.printf("%.0f - %.0f = %.0f", b, c, b-c);		
	}

}
