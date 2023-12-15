import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int year = 0;
		
		System.out.print("년도 입력 : ");
		year = sc.nextInt();
		
		if((year%4 == 0) && (year%100 != 0 )||(year%400 == 0)) {
			System.out.println(year + " 년은 윤년입니다.");
		} else {
			System.out.println(year + " 년은 평년입니다.");
		}
		
	}

}
