
public class Pract5 {

	public static void main(String[] args) {
		
		// 층 출력		
		for (int x=1 ; x<=5; x++) {
			// " " 공백 출력
			for (int y=1;  y<=5-x; y++) {
				System.out.print(" ");
			}
			
			// "*" 별 출력
			for (int y=1; y<=(2*x)-1; y++) {
				System.out.print("*");
			}
			// 층 내리기
			System.out.println();
			
		}
		
	}

}
