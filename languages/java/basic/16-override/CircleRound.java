
public class CircleRound extends Circle {
	
	public CircleRound (int r) {
		super(r);
	}
	@Override
	public void compute() {	// 원의 둘레   = 반지름 * 2 * 3.141592
		double size = getR()*2*Circle.PI;
		setSize(size);
	}
	@Override
	public void output() {		//	출력
		System.out.println("원의 둘레 : "+ getSize());
	}
	
}
