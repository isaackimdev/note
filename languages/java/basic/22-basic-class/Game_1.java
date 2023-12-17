import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game_1 {
	// 선언
	Scanner sc = new Scanner(System.in);
	int computer, my;
	int gameMoney, bettingMoney;
	String result;
	// 입력
	Game_1(int gameMoney) {
		this.gameMoney = gameMoney;
	}
	void inputMenu() throws IOException {
		do {
		System.out.println("1. 가위");
		System.out.println("2. 바위");
		System.out.println("3. 보자기");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 : ");
		my = sc.nextInt();
		} while (my < 0 || my >3);
		
		if(my == 0) endGame();
		
		System.out.print("배팅 금액 : ");
		bettingMoney = sc.nextInt();
		System.out.println("결과를 보려면 Enter를 치세요");
		System.in.read();		// 예외처리를 해줘야 함. (예외전가)
	}	
	void inputContinue () {
		System.out.println("continue(y/n) : ");
		String con = sc.next();
		if(con.equals("y")) {
			if(gameMoney == 0 ) {
				System.out.print("insert coin : ");
				gameMoney = sc.nextInt();
				System.out.println("충전되었습니다.");
			}
		} else if (con.equals("n")) {
			endGame();
		}
	}
	// 연산
	void initComputer() {
		Random random = new Random();
		computer = random.nextInt(3) + 1; // 1~3사이의 임의 정수 저장
	}
	void calcMoney() {
		switch (result) {
		case "win":	gameMoney += bettingMoney;		
			break;
		case "lose": gameMoney -= bettingMoney;
				if(gameMoney < 0) gameMoney = 0;
			break;		
		}
	}
	void resultGame() {
		switch (computer) {
		case 1:	// 가위	
			switch (my) {
			case 1:	result = "draw"; break;	//가위
			case 2:	result = "win"; break;	//바위
			case 3:	result = "lose"; break; //보자기
			}
			break;
		case 2:	// 바위	
			switch (my) {
			case 1:	result = "lose"; break;	//가위
			case 2:	result = "draw"; break;	//바위
			case 3:	result = "win"; break; //보자기
			}
			break;
		case 3:	// 보자기	
			switch (my) {
			case 1:	result = "win"; break;	//가위
			case 2:	result = "lose"; break;	//바위
			case 3:	result = "draw"; break; //보자기
			}
			break;		
		}
	}
	void endGame() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
	// 출력
	String makeString(int n) {
		switch (n) {
		case 1: return "가위";
		case 2: return "바위";
		case 3: return "보자기";
		}
		return null;
	}
	void resultOutput() {		
		System.out.printf("computer : %s you : %s\n", 
				makeString(computer), makeString(my));
		System.out.println("You " + result + "!!");
		System.out.println("당신의 금액은 " + gameMoney + "원 입니다.");
	}
}