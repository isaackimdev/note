import java.util.Scanner;
/* 3개의 숫자 (a,b,c)를 입력받아서 순서대로 출력하시오.
 * 결과
 * 정수입력 : 78
 * 정수입력 : 25
 * 정수입력 : 36
 * 25 36 78
 */
public class Practice6 {

	public static void main(String[] args) {
			// 선언
			Scanner sc = new Scanner(System.in);
			int a=0, b=0, c=0;
			// 입력
			System.out.print("정수 입력 : ");
			a = sc.nextInt();
			System.out.print("정수 입력 : ");
			b = sc.nextInt();
			System.out.print("정수 입력 : ");
			c = sc.nextInt();
			// 연산
			// 출력			
			if (a>b && a>c && b>c) {
				System.out.print(a+" "+ b +" "+c);
			} else if(b>c && b>a && c>a) {
				System.out.print(b+" "+ c +" "+a);
			} else if(c>a && c>b && b>a) {
				System.out.print(c+" "+ b +" "+a);
			} else if(c>a && c>b && b>a) {
				System.out.print(c+" "+ b +" "+a);
			} else if(a>b && a>c && c>b) {
				System.out.print(a+" "+ c +" "+b);
			} else if(b>a && b>c && a>c) {
				System.out.print(b+" "+ a +" "+c);
			} else if(c>a && c>b && a>b) {
				System.out.print(c+" "+ a +" "+b);
			} else {
				System.out.print("같은 수가 있습니다. 다른 수를 입력해주세요.");
			}
		}

}

