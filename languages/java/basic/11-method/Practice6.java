import java.util.Scanner;

// 문제 6. 값을 입력받아 함수호출하여 처리하시오.
 /* [처리조건]
 * 1. main 함수
 *	안에
 *   필요한 변수 반들기
 *   input() 함수들을 호출하여, 품명, 수량, 단가를 입력 받으시오
 *   compute()함수를 호출하여 결과값을 받아서, 총액을 저장하시오
 *   output() 함수를 호출하여 결과를 아래와 같이 출력하시오
 * 
 * 2. coumpute()함수에서 계산된 결과를 리턴하시오
 *  (계산방법 : 총액 = 수량  * 단가)
 *  
 *  < 실행결과 >
 *  품명을 입력하시오 : aaa
 *  수량을 입력하시오 : 10
 *  단가 입력하시요 : 12344
 *  
 *  품명 : aa
 *  금액 ; 100000
 */
public class Practice6 {
	static String inputName(){			// 이름 입력 받기
		Scanner sc=new Scanner(System.in);
		System.out.print("품명을 입력하시오 : ");
		String name = sc.next();
		return name;
	}
	static int inputSu(){				// 수량
		Scanner sc=new Scanner(System.in);
		System.out.print("수량을 입력하시오 : ");
		int su = sc.nextInt();
		return su;
	}
	static int inputPay(){				// 단가
		Scanner sc=new Scanner(System.in);
		System.out.print("단가을 입력하시오 : ");
		int pay = sc.nextInt();
		return pay;	
	}
	static int compute(int su, int pay){
		return su*pay;
	}
	static void output(String name , int sum){
		System.out.println();
		System.out.println("품명 : " + name );
		System.out.println("총액 : " + sum );
	} 
	public static void main(String[] args) {
		// 선언
		String name = ""; 		// 품명
		int su = 0, price =0;     // 수량 및 금액
		int sum = 0 ; 			// 총액
		// 입력
		
		name = inputName();
		su = inputSu();
		price = inputPay();
		// 연산
		sum = compute(su, price);
		// 출력
		
		output(name, sum);
	
	}
}
