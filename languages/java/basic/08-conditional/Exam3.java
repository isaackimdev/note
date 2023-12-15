import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int js = 0;
		
		System.out.print("점수 입력 : ");
		js = sc.nextInt();
		
		if(js >= 90) {
			System.out.println("A학점");
		} else if(js >=80 ){
			System.out.println("B학점");
		} else if(js >=70 ){
			System.out.println("C학점");
		} else if(js >=60 ){
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}

	}

}
