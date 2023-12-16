
public class CircleArea extends Circle {
	
	public CircleArea(int r){
		super(r);
	}
	@Override
	public void compute(){		// 원의 넓이 = 반지름 * 반지름 *3.141592
		double size = getR() * getR() * Circle.PI;
		setSize(size);
	}
	@Override
	public void output(){		// 출력
		System.out.println("원의 넓이 : "+getSize());
	}
	
}
