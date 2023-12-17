
public class Exam1 {
	public static void main(String[] args) {
		String a = "20";
		String b = "3.14";
		// 문자열을 > 원래 자료형으로 바꾸는 것을 Wrapper 클래스 라고 한다.
		int num_a = Integer.parseInt(a);	// static 메소드로 만들어져 있음. [Integer].parseInt(a);   		 // 문자열을 원래의 자료형으로 바꿈.
		double num_b = Double.parseDouble(b);	// static 메소드로 만들어져 있음 [Double].parseDouble(b);	 // 문자열을 원래의 자료형으로 바꿈.
		
		System.out.println(a + 5);
		System.out.println(num_a + 5);
		System.out.println(b + 5);
		System.out.println(num_b + 5);
		
		Integer i = new Integer(123);  // 클래스이지만 정수로써 사용이 가능하다 ㅎㅎ
		// 기본 데이터 형과 객체화 된 데이터는 서로 연산이 가능하다.
		int x = i + 300;
		System.out.println("x = " + x );
		
		i = i+300;
		System.out.println("i =" + i);	// 자료형을 포장해서 만든 클래스로, Wrapper 클래스라고 한다. >> Integer 라고하는 클래스
	}
	
}
