import java.util.Scanner;

public class DoubleSum {	
	// 선언
	Scanner sc = new Scanner(System.in);
	private int fir, sec, mul, result;	// 첫번째 수 , 두번째 수, 배수
	// 입력
	public DoubleSum(int fir, int sec){
		this.mul = 0;
		result=0;
		this.fir = fir;
		this.sec = sec;
	} // 생성자에 변수 초기화를 많이 시켜줌
	
	// 연산
	
	public int getSumOfMul(int mul){
		this.mul = mul;
		for (int x=fir; x<=sec; x++) {
				if(x % mul == 0) {
					result += x;
				}
		}
		return result;
	}
	
	// 출력
	public void output(){
		System.out.println("첫번째 수 = " + fir);
		System.out.println("두번째 수 = " + sec);
		System.out.println("배수 = " + mul);
		System.out.println();
		System.out.println(fir + "에서 " + sec + "사이의 " + 
				mul + "배수의 합은 " + result + "입니다.");
	}
	
}
