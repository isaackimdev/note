import java.util.Scanner;


class AAA {
	
	Scanner sc=new Scanner(System.in);
	int a,b,c;
	
	void input() {

		System.out.print("정수 입력 : ");
		a=sc.nextInt();
		System.out.print("정수 입력 : ");
		b=sc.nextInt();
		
	}
	// 연산 : 저장된 데이터 가공하기
	void plus() {
		c=a+b;
	}

	// 출력 : 결과값 확인하기
	void output() {
		System.out.println(c);
	}
	
}


public class Test1 {

	// 함수들을 묶어 놓은 것이 클래스
	
	public static void main(String[] args) {
		
		AAA aa = new AAA();
		aa.input();
		aa.plus();
		aa.output();
		
	}

}
