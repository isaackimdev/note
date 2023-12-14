/*
 * 입력값 중에서 큰 값을 출력
 */
import java.util.Scanner;

public class Exam8 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num1=0, num2=0;
		int result = 0;
		// 입력
		System.out.print("정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		num2 = sc.nextInt();
		// 연산
		result = (num1 > num2) ? num1 : num2;
		// 출력
		System.out.println("큰수:"+result);
	}
}
