import java.util.Scanner;

public class Gugudan {
	
	int ss, ee;
	
	void setGugudan(){
		Scanner sc = new Scanner(System.in);
		System.out.print("시작단 : ");
		ss=sc.nextInt();
		System.out.print("끝단 : ");
		ee=sc.nextInt();
	}
	
	void dispGugudan(){			// 구구단 출력
		for(int x=ss; x<=ee; x++) { // 단
			for(int y=1; y<=9 ; y++) {	// 1~9
				System.out.printf("%d*%d=%2d ",x,y,(x*y));	
			}
			System.out.println();
		}

	} 	
	
	
}
