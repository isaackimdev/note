import java.util.Scanner;
	
public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언 : 변수 만들기
		String name = "";	// 이름
		int basePay = 0;	// 기본급
		double tax = 0;		// 세금
		int salary = 0;		// 월급
		// 입력 : 변수에 데이터 저장하기
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("기본급 입력 : ");
		basePay = sc.nextInt();
		// 연산 : 저장된 데이터 가공하기
		tax = basePay * 0.033;
		salary = (int)(basePay - tax);
		// 출력 : 결과 확인하기
		System.out.println("*** " + name + "의 월급 ***");
		System.out.println("기본급 : "+ basePay +"원");
		System.out.println("세금"+ (int)tax +"원");
		System.out.println("월급"+ salary +"원");
		
		
		}
}
