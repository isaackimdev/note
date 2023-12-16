import java.util.Scanner;

public class Practice6_1 {
	
	
	static int input_num(){
		Scanner sc = new Scanner(System.in);	
		System.out.println("\n주차 관리 프로그램");
		System.out.println("**************");
		System.out.println("	1. 입차");
		System.out.println("	2. 출차");
		System.out.println("	3. 리스트");
		System.out.println("	4. 종료");
		System.out.println("**************");	
		System.out.print(" 메뉴 : ");
		int num = sc.nextInt();	
		return num;
	}
	static void end(int num) {
		if(num==4) {
			System.out.println("종료합니다.");
			System.exit(0);	// 프로그램 종료 함수에서는 break; 가 안먹힘
		} 
	}
	static void parking_in(int position, boolean[] parking) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("위치 입력 [1~5] : ");
			position = sc.nextInt();
		} while (position <= 0 || position > 5);
		if (parking[position-1]) {		// 비어 있지 않을 경우
			System.out.println(position + "위치에 입차 / 이미 주차되어 있습니다.");
		} else {						// 비어 있을 경우
			System.out.println(position + "위치에 입차 / 주차되었습니다.");
			parking[position-1] = true;
		}
	}
	static void parking_out (int position, boolean[] parking) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("위치 입력 [1~5] : ");
			position = sc.nextInt();
		} while (position <= 0 || position > 5);
		if (parking[position-1]) {		// 비어 있지 않을 경우
			System.out.println(position + "위치에 출차 / 출차 되었습니다.");
			parking[position-1] = false;
		} else {						// 비어 있을 경우
			System.out.println(position + "위치에 출차 / 주차되어 있지 않습니다.");
		}
	}
	static void parking_list(boolean[] parking){
		System.out.println("\n--- 리스트 ---");
		for(int x=0; x<parking.length; x++) {
			System.out.println((x+1) + " 위치 : " + parking[x]);
			
		}
	}
	public static void main(String[] args) {
		// 선언
		
		boolean[] parking = new boolean[5]; //{true, false, true, false, false}; // 주차공간
		int num = 0;				// 메뉴 선택 변수
		int position = 0; 			// 위치값
		// 입력
		while(true) {
			num =input_num();
			end(num);
			// 연산
			// 출력
			switch(num) {
			// 입차
			case 1:
				parking_in(position, parking);
				break;
			// 출차
			case 2:
				parking_out(position, parking);
				break;
			// list
			case 3:
				parking_list(parking);
				break;
			}
			
			
		} //while
	} //main
} //class
