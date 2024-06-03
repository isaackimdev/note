package aop09;

public class CalcMethod {
	public void sum(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a+b));
	}
	public void div(int a,int b) {
		try {
			System.out.println(a + " / " + b + " = " + (a/b));
		}catch(Exception e) {
			System.out.println("0으로 나눌 수 업습니다.");
		}
	}
}
