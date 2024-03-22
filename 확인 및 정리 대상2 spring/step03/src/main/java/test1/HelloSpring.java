package test1;

public class HelloSpring {
	
	public static void main(String[] args) {
		/*	내가 짠 코드
		Calc calca = new CalcAdd();
		calca.calculate(25, 36);
		Calc calcm = new CalcMul();
		calcm.calculate(25, 36);
		*/
		
		Calc calc = new CalcAdd();
		calc.calculate(25, 36);
		calc = new CalcMul();
		calc.calculate(25, 36);
		
		
	}
}
