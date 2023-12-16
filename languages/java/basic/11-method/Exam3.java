
public class Exam3 {
	static double plus(double a, double b) {
		return a + b;

	}
	
	static double minus(double a, double b) {
		return a - b;

		
	}
	public static void main(String[] args) {
		
		double a=100.5, b=200.7;
		System.out.println(a+"+"+b+"="+plus(a,b));
		
		a=10.5;
		b=20.7;
		System.out.println(a+"-"+b+"="+minus(a,b));
		
	}

}
