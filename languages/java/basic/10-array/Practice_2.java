import java.util.Scanner;

public class Practice_2 {

	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int select = 0 ;			// 메뉴 선택 변수
		boolean[] parking = new boolean[5];			// 주차장 현황
		
		// 입력
		while(true) {
			System.out.println("주차 관리 프로그램");
			System.out.println("*************");
			System.out.println("	1. 입차");
			System.out.println("	2. 출차");
			System.out.println("	3. 리스트");
			System.out.println("	4. 종료");
			System.out.println("*************");
			System.out.print(" 메뉴 : ");
			select = sc.nextInt();
			if(select == 4) {
				System.out.println("종료합니다.") ;
			}
			break;
			
//			switch (select) {
//				case 1 :
//					break;
//				case 2 :
//					break;
//				case 3 : 
//					System.out.println("\n--- 리스트 ---");
//					for(int x = 0; x<parking.length; x++) {
//						System.out.println((x+1) +" 위치 : " + parking[x] );					
//					}
//					break;
//			}
			
		} // while
		// 연산
		// 출력

	}	// main

}	// class
