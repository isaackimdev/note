
public class Exam7 {
	public static void main(String[] args) {
		int a = 100, b = 200;
		int x = 5, y = 3;
		
		// 논리연산에 대한 결과는 boolean형이다.
		// boolean 값끼리는 논리연산이 가능하다.
		boolean r1 = a>=b;
		boolean r2 = x>=y;
		boolean result1 = r1 && r2;
		boolean result2 = r1 || r2;
		boolean result3 = !(r1 || r2);
		System.out.println("result1 = " + result1);		
		System.out.println("result2 = " + result2);		
		System.out.println("result3 = " + result3);		
	}
}
