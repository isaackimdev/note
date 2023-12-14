//	문제3. 삼항 연산자(조건 연산자)를 이용해서 아래와 같이 결과가 나오도록 프로그램을 작성하세요.
// 실행결과
//
// 첫번째 수 = (5)
// 두번째 수 = (7)
// 첫번째 수[ 5 ]가 두번째 수[ 7 ]보다 작은 수 입니다.

import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		
		// 선언
		Scanner sc = new Scanner(System.in);
		int a=0;
		int b=0;
		// 입력
		System.out.print("첫번째 수 = ");
		a = sc.nextInt();
		System.out.print("두번째 수 = ");
		b = sc.nextInt();
		// 연산
		String str1 ="첫번째 수("+a+")가 두번째 수("+b+")보다 큰 수 입니다.";
		String str2 ="첫번째 수("+a+")가 두번째 수("+b+")보다 작은 수 입니다.";
		// 출력
		System.out.println((a > b) ? str1 : str2);
		}
}
