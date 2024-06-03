package test1;

public class HelloSpring {
	
	public static void main(String[] args) {
		Calc calc = new CalcAdd();
		calc.calculate(25, 36);
		calc = new CalcMul();
		calc.calculate(25, 36);
	}
}
