
public class Test {
	

	// 결과 자료형 = 리턴 값의 자료형 : 컴퓨터에게 리턴값의 자료형을 알려주는 것
	static int plus(int a, int b) { // 매개변수 : 다른 함수에서 전달된 값을 저장하는 변수
		return a + b;		// 되돌아가라 : 호출된 곳으로 되돌아가라. 
	}		// 결과값 = 리턴값		만일, 리턴값이 있으면 그 값을 가지고 되돌아 감
	
	
	static void output(int cc) {
		System.out.println(cc);
	}
	
	
	public static void main(String[] args) {
		
		// 선언
		int c;
		// 입력
		// 연산
		c = plus(1, 2);		// 함수의 호출 : 함수의 사용법 => 우선순위 : 2.5 순위
		// 출력
		output(c);
//		return;			// 이 리턴 값은 메인 함수에 대한 리턴 값 생략할 수 있음.
		
	}

}
