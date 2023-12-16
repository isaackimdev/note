import java.util.Scanner;

public class Practice4_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.print("문자 입력 : ");
		ch = sc.next().charAt(0);
		
		if (ch >= 'A'&& ch <='Z') {
			System.out.print(ch+"->"+(char)(ch+32)); 
		} else if  (ch >= 'a'&& ch <='z' ) {
			System.out.print(ch+"->"+(char)(ch-32)); 
		}
		
	}

}
