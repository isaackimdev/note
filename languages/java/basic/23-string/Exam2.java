//split() 을 사용하지 않고 구별하기 이메일주소에서 아이디와 도메인을 구별하기

public class Exam2 {

	public static void main(String[] args) {
		//student@java.com
		// 1) 이메일 주소 정의
		String email = "student@java.com";
		// 2) "@" 가 나타나는 위치 얻기
		int pos = email.indexOf("@");
		// 3) 처음부터 "@" 가 나타나는 위치까지 자르기 ==> 아이디
		String id2 = email.substring(0,pos);
		System.out.println(id2);
		// ID
		String id = email.substring(0,7);
		System.out.println(id);
		// 4) "@" 가 나타나는 위치 다음 부터 끝까지 자르기 ==> 도메인
		String ema2 = email.substring(pos+1);
		System.out.println(ema2);
		// 도메인
		String ema = email.substring(8,16);
		System.out.println(ema);
		
		
	}

}
