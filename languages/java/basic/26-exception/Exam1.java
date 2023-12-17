
public class Exam1 {
	
	public static void main(String[] args) {
		// 문자열의 숫자 변환에 아무런 문제가 없다.
		String year1 = "1980";
		int age1 = 2018 - Integer.parseInt(year1) + 1 ;
		System.out.println(age1);
		
		// 숫자로 변환할 수 없으므로, 에러가 발생한다.
		try {		// 예외처리 명령어 오류를 알려주고, 
			String year2 = "뭘까요";
			int age2 = 2018 - Integer.parseInt(year2) + 1 ;
			System.out.println(age2);
		} catch(Exception e) {	// try 라는 예외처리 명령어를 사용하려면 catch 가 반드시 한개 이상 있어야 함.
			System.out.println("에러가 발생했습니다.");
			System.out.println("원인 : " + e.getMessage());
		}
		
		//1. 실행중에 멈춤을 억제함
		//2. 사용자의 반감을 줄여줄 수 있음
		System.out.println("--- 프로그램을 종료합니다. ---");
	}
}
