import java.util.Scanner;

public class Practice1 {
	static double input_num (String str ){
		Scanner sc = new Scanner(System.in);
		System.out.print(str + "번째 수 : ");
		double num = sc.nextDouble();
		return num;
	}
	static String input_op(){
		Scanner sc = new Scanner(System.in);
		System.out.print(" 연산자 : ");
		String op = sc.next();
		return op;
	}
	static String calculate (String op, double num1 , double num2){
		double result=0;
		switch(op) {
		case "+": result = num1 + num2;
			break;
		case "-": result = num1 - num2;
			break;
		case "*": result = num1 * num2;
			break;
		case "/": result = num1 / num2;
			break;
		default:
			System.out.println("연산자가 잘못 입력되었습니다. [+,-,*,/]");
			return "error";
			//return; // 현재 함수를 종료시킴		
		}
		return result+"";
			
	}
	
	public static void main(String[] args) {
		// 선언 : 변수만들기
		Scanner sc = new Scanner(System.in);
		double num1=0, num2=0;
		String op="";		
		double result=0;
		// 입력 : 변수에 데이터 저장하기
		
		num1 = input_num("첫" );
		num2 = input_num("두" );

		
		op = input_op();
		
		
		// 연산 : 저장된 데이터 가공하기
		String str_result = calculate(op, num1, num2);
//		result = calculate(op);
			// 출력 : 결과확인하기
			if(str_result != "error"); { // 문자열 비교함수 : 같으면 true, 같지 않으면 false
				//if(op != "error") 로도 사용은 가능하나, 주소로써 같은지를 비교 함.
				result = Double.parseDouble(str_result);	// 문자열을 실수로 변환시켜주는 명령어
			System.out.printf("%.3f %s %.3f = %.3f", num1, op, num2, result);
		}
	}
}
