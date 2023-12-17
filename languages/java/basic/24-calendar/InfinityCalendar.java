import java.util.Calendar;
import java.util.Scanner;

public class InfinityCalendar {
	// 선언
	Scanner sc = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	int y, m, dayNum;	 // 년, 월, 요일수
	// 입력
	void input() {
		do {
			System.out.print("년도? ");
			y = sc.nextInt();
		} while (y<1);
		do {
			System.out.print("월? ");
			m = sc.nextInt();
		} while(m<1 || m>12);
	}
	// 연산
	void setDate() {
		cal.set(y, m-1, 1);		// 년 월을 입력 받음... 그달의 1일 체크
		// 그달 1일의 요일수 저장
		dayNum = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일 수 : " + dayNum);
	}
	
	// 출력
	void outputTitle () {
		System.out.println();
		System.out.printf("%s %s %s %s %s %s %s\n ",
				"일", "월", "화", "수", "목", "금", "토");
		System.out.println("------------------");
	}
	void output () {
		// 요일수만큼 커서 옮기기
		for(int i=1; i<dayNum; i++) {
			System.out.printf("%2s "," ");
		}
		// 이번달의 총일수 구하기
		int dayOfMonth = cal.getActualMaximum(Calendar.DATE);
		// 날짜 출력
		for(int i = 1; i<=dayOfMonth; i++) {
			System.out.printf("%2d ", i);
			dayNum++;
			// 일요일인가? (일요일의 요일수 = 1)
			if(dayNum%7 == 1) {
				System.out.println();
			}
		}
	}
}
