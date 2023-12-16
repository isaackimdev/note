import java.util.Scanner;

// interface 와 다형성을 이용하여 프로그램을 완성 > 부모클래스 사용
public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int select = 0 ;	// 선택지
		
		Shape[] shape = new Shape[2];
		shape[0] = new Rectangle();
		shape[1] = new Circle();
		
		while(true) {
			System.out.println();
			System.out.println("1. 사각형 2. 원 3. 종료");
			System.out.print("   select(1-3) : ");
			select = sc.nextInt();
			
			switch(select) {
				
			case 1 :
				shape[0].onDraw();
				shape[0].onDelete();
				break;
			case 2 :
				shape[1].onDraw();
				shape[1].onDelete();
				break;
			case 3 :
				System.out.println("종료합니다.");
				System.exit(0);		// 종료의 두가지 방법.
				break;
			default: shape = null;
			}
			if (select == 3) break;
		}
		
		
		
	}
}
