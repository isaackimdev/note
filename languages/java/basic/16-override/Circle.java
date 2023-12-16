
public class Circle {
	private int r ;			// 반지름
	private double size ;	// 계산값 저장
	public static final double PI = 3.141592;	// 원주율 기준 값(변경 X)
	
	Circle(int r){	// 생성자 반지름 대입
		this.r = r;
	}
	// 상속받는 자식 클래스들에게 기능을 제시하는 역할 
	public void compute() {
	}
	public void output() {
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}	
}

