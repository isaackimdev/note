// main() 함수에서 각각 호출하고 계산된 결과를 return 받아서 main()에서
// 출력하시오.

//8 , 5 ,20 , 2,33 소수점 둘쨰자리까지 출력

public class Practice5 {
	
	// 연산
	static int sum(int a, int b){	// 더하기
		int sum = a+b;
		return sum;
	}
	static int sub(int a, int b){
		int sub = a-b;
		return sub;
	}
	static int mul(int a, int b){
		int mul = a+b;
		return mul;
	}
	static double div(int a, int b){
		double div = (double)a/b;
		return div;
	}
	static void output(int sum, int sub, int mul, double div){
		System.out.println("더하기 : " + sum(3,5));
		System.out.println("빼기 : " + sub(7,2));
		System.out.println("곱하기 : " + mul(4,5));
		System.out.printf("나누기 : %.2f" , div(7, 3)); // 소수점 2자리 출력으로 수정
	}
	// 출력
	
	public static void main(String[] args) {
	
		
		// 선언
		int sum=0, sub=0, mul=0; //더하기 , 빼기, 곱하기 값
		double div = 0;			// 나누기 값
		
		sum = sum(3, 5);
		sub = sub(7, 2);
		mul = mul(4, 5);
		div = div(7, 3);
		// 출력
		output(sum, sub, mul, div);
//		System.out.println("더하기 : " + sum(3,5));
//		System.out.println("빼기 : " + sub(7,2));
//		System.out.println("곱하기 : " + mul(4,5));
//		System.out.println("나누기 : " + div(7, 3));
	
		
		
		
	}

}
