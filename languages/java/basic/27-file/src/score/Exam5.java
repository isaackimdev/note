package score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		Scanner sc = new Scanner(System.in);
		Score score = new ScoreImpl();
		int ch;
		
		while(true) {
			do {
				System.out.println("1. 입력");
				System.out.println("2. 출력");
				System.out.println("3. 학번검색");
				System.out.println("4. 이름검색");
				System.out.println("5. 총점 내림차순 정렬");
				System.out.println("6. 학번 오름차순 정렬");
				System.out.println("7. 파일저장");
				System.out.println("8. 파일읽기");
				System.out.println("9. 종료");	
				System.out.println("------------------------");
				System.out.print("번호 : ");
				ch = sc.nextInt();
			} while (ch<1 || ch>9);
			switch (ch) {
			case 1 : score.input();	break;
			case 2 : score.print();	break;
			case 3 : score.searchHak();	break;
			case 4 : score.searchName();	break;
			case 5 : score.descSortTot();	break;
			case 6 : score.ascSortHak();	break;
			case 7 : score.saveFile(); 		break;
			case 8 : score.readFile();		break;
			case 9 : System.out.println("종료합니다.");
				  	 System.exit(0);
				
			}
	
		}
	
		
	} // main
} // exam5
