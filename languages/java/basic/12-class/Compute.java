public class Compute {
	int x,y,sum,sub,mul;
	double div;

	void setX(int x) {	// setter 저장
		this.x = x;
	}	// 변수 x 에 값 대입
	void setY(int y) {	// setter 저장
		this.y = y;
	}   // 변수 y 에 값 대입	
	
	int getX() {	// getter 보기
		return x;
	}   // 변수 x 값  리턴
	int getY() {	// getter 보기
		return y;
	}   // 변수 y 값  리턴
	
	int getSum() {
		sum = x+y;
		return sum;
	} 
	int getSub() {
		sub = x-y;
		return sub;
	}
	int getMul() {
		mul = x*y;
		return mul;
	}
	double getDiv() {
		div = (double)x/y;
		return div;
	}
	
	void outputTitle(){
		System.out.println("X   Y  SUM  SUB   MUL  DIV");
	}
	
	void outputCalc() {
		System.out.printf("%3d %3d %3d %3d %3d %.2f\n",
				x, y, sum, sub, mul, div);
	
	}

}
