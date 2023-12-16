import java.util.Scanner;
public class DrawData {
	Scanner sc = new Scanner(System.in);
	int height ; 		// 높이
	String st = "";		// 출력 문자
	
	void draw() {				// 다형성이용
		
	}	
	int setHeight(int height) {			 // 높이 대입
		this.height = height;
		return height;
	}
	String setOutchar(String st) {			// 문자 대입
		this.st = st;
		return st;
	}
	int getHeight() {			// 높이 리턴
		return height;
	}
	String getOutchar() {		// 출력문자 리턴
		return st;
		
	}

}
