import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		// 선언
		int num1=0, num2=0;
		Scanner sc = new Scanner(System.in);
		// 입력
		System.out.print("정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		num2 = sc.nextInt();
		// 연산
		int resultplus = num1 + num2;
		int resultMinus = num1 - num2;       // 1.낙타체 일반적으로 많이 씀
		int result_multiply = num1 * num2;  // 2.언더바 일반적으로 많이 씀
		int result_divide = num1 / num2;
		int resultNamugi = num1 % num2;
		// 출력
		System.out.println(num1 + " + " + num2 + " = " + resultplus);
		System.out.println(num1 + " - " + num2 + " = " + resultMinus);
		System.out.println(num1 + " * " + num2 + " = " + result_multiply);
		System.out.println(num1 + " / " + num2 + " = " + result_divide);
		System.out.println(num1 + " % " + num2 + " = " + resultNamugi);
	
	}
}
