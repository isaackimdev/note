
public class Exam6 {
	
	static int plus(int a, int b) {
		return a+b ;
	}
	static double plus(double a, double b) {
		return a+b ;
	}
	static double plus(int a, double b) {
		return a+b ;
	}
	static double plus(double a, int b) {
		return a+b ;
	}
	
	public static void main(String[] args) {
		System.out.println("5 + 7 = " + plus(5,7));			 //plus(int, int)
		System.out.println("5.5 + 7.7 = " + plus(5.5, 7.7)); //plus(double, double)
		System.out.println("5 + 7.7 = " + plus(5, 7.7));	 //plus(int, double)
		System.out.println("5.5 + 7 = " + plus(5.5, 7));	 //plus(double, int)
	}
}
