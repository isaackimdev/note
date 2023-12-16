
public class Practice4_1 {

	public static void main(String[] args) {
		
		for (int x=1; x<=5; x++ ) { 		// 층 : 5층
			// 공백문자 출력
			for(int y=1; y<=5-x; y++ ) {
				System.out.print(" ");	
			}
			
			// 별 출력
			for (int y=1; y<=(2*x - 1); y++ ) {
				System.out.print("*");
			}
			// 1줄 넘김
			System.out.println(); 		// syso 입력 후 ctrl + space
		}
		
		for (int x=4; x>=1; x-- ) { 		// 층 : 5층
			// 공백문자 출력
			for(int y=1; y<=5-x; y++ ) {
				System.out.print(" ");	
			}
			
			// 별 출력
			for (int y=1; y<=(2*x - 1); y++ ) {
				System.out.print("*");
			}
			// 1줄 넘김
			System.out.println(); 		// syso 입력 후 ctrl + space
		
		}
	}

}
