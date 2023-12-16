//
// 1~100 사이의 수 3의 배수 이면서 7의 배수 구하기
// 조건 for 문과 && 연산자를 이용

public class Practice6 {

	public static void main(String[] args) {
		
		// 선언
		int x=0;
		// 입력
		
		for (x=1; x<=100; x++) {
			if((x%3==0)&&(x%7==0)) {
				System.out.print(x+" ");
			}
		}
			
	}

}
