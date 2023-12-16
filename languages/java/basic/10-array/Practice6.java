import java.util.Scanner;

//문제6 주차 관리 프로그램을 작성하세요.
// - 주차는5대를 할 수 있다. => 배열로 변수 만들기
// - 주차된 곳 : true, 비어있는 곳 : false

public class Practice6 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int[] park = new int[5];		// 주차 5대 가능한 공간 (주차장)
		boolean[] space = new boolean[] {true, false, true, false, false} ;			// 주차 [ y / n ]
		int select = 0 ;		// 메뉴 선택 변수
//		int s1 = 0 ; 			// 위치 확인 변수
		// 입력
			System.out.println("주차 관리 프로그램");
			System.out.println("***************");
			System.out.println("	1. 입차");
			System.out.println("	2. 출차");
			System.out.println("	3. 리스트");
			System.out.println("	4. 종료");
			System.out.println("***************");	
			System.out.print(" 메뉴 : ");
			select = sc.nextInt();		// <입차 / 출차 / 리스트  / 종료>
		// 연산
		if(select==3) {		// 리스트 메뉴
			for(int x=0; x<space.length; x++) {
			System.out.println((x+1)+"위치 : "+space[x]+" ");
			}
			select = 0;
			System.out.print("메뉴 : ");	
			select = sc.nextInt();		// <입차 / 출차 / 리스트  / 종료>
		} 
		if(select==1) {
			System.out.print("위치 입력 : ");	// 입차할 위치 입력
			select = sc.nextInt();			// 입차할 위치 저장
			for (int x=0; x<park.length; x++) {
				//for(int y=0; y<park.length; y++) { // 주차 비교
					if(space[select-1] == true) {
						System.out.println(select + "위치엔 이미 주차되어있습니다.");
						
					} else {
						System.out.println(select + "위치에 입차");
						space[select-1]=true;
						//break;
					} 
				//}
			}
		}
		if(select==2) {
			System.out.print("위치 입력 : ");	// 출차할 위치 입력
			select = sc.nextInt();			// 출차할 위치 저장
			for (int x=0; x<park.length; x++) {
				//for(int y=0; y<park.length; y++) { // 주차 비교
					if(space[select-1] == true) {
						System.out.println(select + "위치에서 출차");
						space[select-1]=false;
						//break;
					} else {
						System.out.println(select + "주차되어 있지 않습니다.");
						//break;
					} 
				//}
			}
		}
		if(select==4 ) {	// 종료 메뉴
			System.out.println("종료되었습니다.");
		}
	} //main
} // class
