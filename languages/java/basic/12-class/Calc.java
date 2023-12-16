// 클래스 앞에 public을 붙일 경우
// 반드시 파일이름과 클래스 이름은 똑같아야 한다.

public class Calc {
	int plus(int x, int y) {
		return x+y;
	}
	int minus(int x, int y) {
		return x-y;
	}
	int multiply(int x, int y) {
		return x*y;
	}
	int divide(int x, int y) {
		int result = 0;
		if(y!=0) {	// 0 으로 나눌 수 없으므로...
			result = x/y;
		}
		return result;
	}
	int f(int x, int y) {
		int result = plus(x,y) + multiply(x,y);
		return result;
	}
}
