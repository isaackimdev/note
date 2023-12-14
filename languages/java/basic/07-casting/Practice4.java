import java.io.IOException;
import java.util.Scanner;

public class Practice4 {
	public static void main(String[] args)throws IOException {
		// 선언
		Scanner sc = new Scanner(System.in);
		char ch, result;
		// 입력
		System.out.print("문자 입력:");
		ch = sc.next().charAt(0);  			 // 2번째
		//ch = (char)System.in.read(); 		 // 1번째
		
		// 연산
		result = (ch >= 'A'&& ch <='Z' ) ? (char)(ch+32) : 
				 (ch >= 'a'&& ch <='z' ) ? (char)(ch-32) : '0';
		// 출력
		System.out.println((result != '0') ? (ch +"->"+ result) :"문자 아닙니다");
	}
}
