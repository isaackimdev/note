import java.util.Scanner;

class BBB {
	// 선언 : 변수 만들기
	Scanner sc = new Scanner(System.in);
	int a, b, c;
	// 입력 : 변수에 데이터 저장하기
	void input() {
		System.out.print("정수 입력 : ");
		a = sc.nextInt();
		System.out.print("정수 입력 : ");
		b = sc.nextInt();
	}
	// 연산 : 저장된 데이터 가공하기
	void plus () {
		c = a + b;
	}
	int plus (int a, int b) {
		return a + b;
	}
	// 출력 : 결과값 확인하기
	void output () {
		System.out.println(c);
	}
}