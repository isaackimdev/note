package test2;

public class CalcMul implements Calc{
	int x, y;	

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
	}

}









