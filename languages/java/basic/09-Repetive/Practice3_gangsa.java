import java.util.Scanner;

public class Practice3_gangsa {
	
	static int input_dan (){
		Scanner sc = new Scanner(System.in);
			System.out.print("몇 단을 출력할 지 입력하시오 : ");
			int dan = sc.nextInt();

		return dan;
	}
	
	static String input_continue(){
		Scanner sc = new Scanner(System.in);
		System.out.print("선택하시오(y:계속):");
		String select = sc.next();
		return select;

	}
	static void output_gugudan(int dan){
		// 연산
		for(int x=1; x<=9; x++) {	// 1~9
			System.out.printf("%d * %d = %d\n", dan, x, dan*x);
			}
	}
	
	static void end(){
		System.out.println("종료되었습니다.");
	}
	
	public static void main(String[] args){
		// 선언

		int dan = 0;
		String select="";
		// 입력
		for(;true;) {
			dan = input_dan();
		// 출력
			output_gugudan(dan);
			select = input_continue();
			if(!select.equals("y")) {
				break;
			}
		
		}
		
		end();

	}
}
