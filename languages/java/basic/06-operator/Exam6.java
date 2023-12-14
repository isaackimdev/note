import java.util.Scanner;

public class Exam6 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num1=0, num2=0;
		// 입력
		System.out.print("정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		num2 = sc.nextInt();
		// 연산 : 관계연산자의 연산 결과는 boolean 값이다. 
		boolean result1 = num1 == num2;
		boolean result2 = num1 != num2;
		boolean result3 = num1 > num2;
		boolean result4 = num1 < num2;
		boolean result5 = num1 >= num2;
		boolean result6 = num1 <= num2;
		// 출력
		System.out.println("result1= " + result1);
		System.out.println("result2= " + result2);
		System.out.println("result3= " + result3);
		System.out.println("result4= " + result4);
		System.out.println("result5= " + result5);
		System.out.println("result6= " + result6);
				
	}
}
