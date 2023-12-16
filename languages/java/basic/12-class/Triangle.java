import java.util.Scanner;

public class Triangle {
	// 선언
	Scanner sc = new Scanner(System.in);
	int base, height;	// 전역 변수 
	// 입력

	void setTriangle(int b, int h) {
		base = b;
		height = h;
	}
	void setTriangle(){
		System.out.print("밑변 : ");
		base = sc.nextInt();
		System.out.print("높이 : ");
		height = sc.nextInt();
	}

	// 연산
	double getArea(){
		return base*height / 2.0;
	}	
	// 출력
	void output(){
	System.out.println("삼각형의 넓이 : " + getArea());
	}	
}
