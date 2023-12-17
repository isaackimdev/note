import java.util.Random;
// import java.util.*; // 모든 API 클래스를 사용하겠다고 선언 ' * ';
// java.lang 안에 있는 기능들은 new를 해주지 않고도 사용할 수 있는 기능

public class Exam4 {
	public static void main(String[] args) {
		// 다섯자리의 인증번호 생성하기
		String authNum = "";
		Random random = new Random();
		for(int x=0; x<5; x++ ) {
			authNum += random.nextInt(10); // 0~9 사이의 임의의 정수 1개를 만들어냄
		}
		
		System.out.println("인증번호 : " + authNum);
		
	}
}
