import java.util.Scanner;

public class Test0508 {

	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int select = 0;
		Test manage = new TestImpl();
		
		while(true) {
			do {
				System.out.println("───A company salary management program (Menu)────");
				System.out.println("1. 등록");
				System.out.println("2. 출력");
				System.out.println("3. 수정");
				System.out.println("4. 검색");
				System.out.println("5. 종료");
				System.out.print("Menu를 선택해주세요. : ");
				select = sc.nextInt();
			} while (select < 1 || select > 5 );
			
			System.out.println();
			
			switch (select) {
			case 1 : manage.input(); break;					// 등록하기
			case 2 : manage.print(); break;					// 출력하기
			case 3 : manage.edit(); break;					// 수정하기
			case 4 : manage.searchName(); break;			// 검색하기
			case 5 : System.out.println("종료합니다.");		// 종료하기
					System.exit(0);
			}
		} // 전체 while 문
	}
}
