import java.util.Scanner;

public class Practice4 {
	static char input ( ) {
		char ch;
		Scanner sc = new Scanner(System.in);
		System.out.print("문자입력:");
		ch = sc.next().charAt(0);
		return ch;
	}
	
	static void output (char ch) {
		if(ch >= 'A'&& ch <= 'Z') {
			System.out.println(ch+"->"+ (char)(ch + 32));
		} else if(ch >= 'a' && ch <='z') {
			System.out.println(ch+"->"+ (char)(ch - 32));
		} else {
			System.out.println("문자가 아닙니다.문자를 입력해주세요.");
		}
	}
	public static void main(String[] args) {
		// 선언
		char ch;
		// 입력
		ch = input();
		// 연산
		// 출력
		output(ch);
	}

}
