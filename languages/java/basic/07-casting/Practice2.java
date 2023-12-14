/*
 *  문제 2. 금액(돈)이 5679원일때 아래와 같이 출력하시오.
 *  
 *  실행결과
 *  금액 : 5679원
 *  천원 : 5장
 *  백원 : 6개
 *  십원 : 7개
 *  일원 : 9개
 *  몫과 나머지
 */


 public class Practice2 {
	public static void main(String[] args) {
		// 선언
		int money = 0;	// 금액
		int oman = 0;	// 오만원
		int man = 0;	// 만원
		int cheon = 0;	// 천원
		int baek = 0;	// 백원
		int ten = 0;	// 십원
		int one = 0;	// 일원
		int namugy = 0; // 나머지값 저장
		// 입력
		money = 5679;
		// 연산
		oman = money / 50000; 	// 몫 저장
		namugy = money % 50000; // 나머지 저장
		man = namugy / 10000;	// 몫 저장
		namugy = namugy % 10000;// 나머지 저장
		cheon = namugy / 1000;
		namugy = namugy % 1000; // 나머지 저장
		baek = namugy / 100;
		namugy = namugy % 100;  // 나머지 저장
		ten = namugy / 10;
		one = namugy % 10; 	// 나머지 저장
		// 출력
		String str_oman = "오만원: " + oman + "\n";
		String str_man = "만원  : " + man + "\n";
		String str_no_value = "";	
		System.out.println("금액  : " + money +"원");
		System.out.print((oman==0) ? str_no_value : str_oman);
		System.out.print((man==0) ? str_no_value : str_man);
		System.out.println("천원  : " + cheon + "장");
		System.out.println("백원  : " + baek + "개");
		System.out.println("십원  : " + ten + "개");
		System.out.println("일원  : " + one + "원");
	}
	
}
