
public class Exam4 {
	public static void main(String[] args) {
		int x = 100;
		int y = 50;
		Calc calc = new Calc();
		System.out.println(x+"+"+y+"="+calc.plus(x, y));
		System.out.println(x+"-"+y+"="+calc.minus(x, y));
		System.out.println(x+"*"+y+"="+calc.multiply(x, y));
		System.out.println(x+"/"+y+"="+calc.divide(x, y));
		System.out.printf("f(%d, %d)=%d", x,y , calc.f(x, y));
	}

}
