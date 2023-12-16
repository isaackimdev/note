import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
	
			// 선언
			Scanner sc = new Scanner(System.in);
			int in=0;
		
			// 입력
			System.out.print("몇 단을 출력할지 입력하시오 (1~9):");
			in = sc.nextInt();
			// 연산
			int a;
			for (a=in; in<=9; in++) {			// 단
				if(a%in==0) {
					
					for(int b=1; b<=9; b++)	{		// 1~9
						System.out.printf("%d*%d=%2d\n ", in, b, in*b);
					
					}
				}
				
				
			}
			// 출력
				System.out.println("선택학시오(y:계속) : "); //y 입력시 초기화
				String ii;
				String y;
				ii = sc.next();
				
				if (ii==(String)"y") {
					
				};
				
				
				
	}

}
