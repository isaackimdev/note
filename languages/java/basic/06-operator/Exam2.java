
public class Exam2 {
	public static void main(String[] args) {
		/** 정수의 나눗셈 */
		int a = 7, b = 3;
		int result1 = a / b;
		System.out.println("7 / 3=" + result1);
		/** 실수의 나눗셈 */
		double c = 7.0, d = 3.0;
		double result2 = c / d;
		System.out.println("7.0 / 3.0=" + result2);
		/** 정수와 실수를 계산 */
		double result3 = c / b;
		System.out.println("7.0 / 3=" + result3);
		/** 나머지 계산 */
		double result4 = c % 3.3; // c언어에서는 정수만 올 수 있다.
		System.out.println("7.0 % 3.3 =" + result4); // c언어처럼 정수로 주로 사용하세요.
		/** 0으로 나누기 */
		double result5 = a / 0.0 ;
		System.out.println("7 / 0.0=" + result5); 
		// 윗 내용 정수로써 0으로 나눠주면 안되나, 실수로써 나눠주는 값은 Infinty 무한대 값이 나옴
	}
}
