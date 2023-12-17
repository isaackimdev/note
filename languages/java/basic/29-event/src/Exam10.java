// @ FunctionalInterface 를 사용하면 이 인터페이스에는 1개의 메소드만 선언할 수 있다.
// 2개 이상의 메소드가 선언되면 에러가 발생한다.
@FunctionalInterface		// 람다식을 갖기 위한 경우, 함수를 하나만 갖기를 원하는 경우에 어노테이션 @FunctionalInterface 를 쓴다. 실행에는 변화가 없고, 제약만 걸어줌.
interface Calculate {	
	int operation(int a, int b);	// 익명클래스를 이용하여 더하기 기능을 넣겠다.
//	int ex(int a, int b);
	
}

public class Exam10 {
	// 람다식 표현 Lambda Expression
	
	public static void main(String[] args) {
		
		
		// 인터페이스를 익명클래스의 방법으로 사용
		Calculate calculateAdd = new Calculate() {	// 상속의 약식 표현, 익명클래스 형태
			
			@Override
			public int operation(int a, int b) {
				
				return a+b;
			}

//			@Override
//			public int ex(int a, int b) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
		};
		
		System.out.println(calculateAdd.operation(100, 200));
		
		/** 람다표현식도 익명 클래스, 익명클래스를 좀더 간략하게 만든 것 */
		/** The target type of this expression must be a functional interface 여럿 몼 씀, 람다 표현식은 한개만 써야 함*/
		
		// 람다 표현식으로 전환 1		  // 매개변수 목록 , 화살표 토큰 , 처리식
		Calculate calculateAdd1 = (int a, int b) -> {
				int result = a + b;
				return a+b; 
			};
		System.out.println(calculateAdd1.operation(100, 200));
		// 람다 표현식으로 전환 2
		Calculate calculateAdd2 = (int a, int b) -> a+b;	// 리턴값이 있을 때, 더 간편하게 표현
		System.out.println(calculateAdd2.operation(100, 200));
		// 람다 표현식으로 전환3 : 리턴값이 있을 경우
		Calculate calculateAdd3 = (a, b) -> a+b;
		System.out.println(calculateAdd3.operation(100, 200));
		// 람다표현식으로 전환 4
		System.out.println(
				((Calculate)((a, b) -> a+b)).operation(100, 200)
				);
		
	}

}
