package test1;

public class CalcAdd implements Calc {

	@Override
	public void calculate(int x, int y) {
		System.out.printf("%d + %d = %d\n",x,y,x+y);
	}

}
