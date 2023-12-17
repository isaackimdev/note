import java.util.Random;
import java.util.Scanner;
/*
 * `문제2 가위바위보 게임 // 기본 금액 1000 원을 제공
 * `가위 1 바위2 보자기 3 임의값을 컴퓨터에게 저장
 * `베팅을 하여 이기면 금액 획득 지면 금액 줄임
 *  /Game.java로 빼기.
 *  문자열 비교 String a = "A" ; >>> a.equals("A")
 */
public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Random random = new Random();	// 랜덤 숫자 생성
		int select = 0 ; // 메뉴선택
		int coin = 1000 ; 	 // 기본 코인 
		int bet = 0 ;		// 베팅
		int com = 0 ; 	 // 컴퓨터 랜덤 숫자 생성할 예정
		String Cresult =""; // 1. 가위 2. 바위 3. 보 => 컴퓨터 결과값
		String Mresult = ""; // 1. 가위 2. 바위 3. 보 => 내 결과값 
		
		
		while(true) {
			com = random.nextInt(4);	//0~3 사이의 임의의 정수 1개를 만들어 냄.
			System.out.println("기본 coin : " + coin + "\n");
			
			Game game = new Game();
			game.menu(); 
			
			System.out.print("메뉴 선택 : ");
			select = sc.nextInt();
			if(select == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			
			System.out.print("베팅 금액 : ");
			bet = sc.nextInt();
			
			// 내 선택에 따라 결과값을 나타냄.
			Mresult = game.selectResult(select);
		
			// 컴퓨터 선택에 따라 가위바위보 결과값을 보여줌.
			Cresult = game.com(com);
			
			
			// 화면 출력
			game.Routput(Cresult, Mresult);
			
			if (Cresult == Mresult) {
				System.out.println(" You draw!!");	// 비길때
			} else if (Cresult != Mresult) {	// 이기거나, 질때
				if ((com==1 && select ==2) || (com==2 && select == 3) || (com == 3 && select == 1)) {
					System.out.println("You win!!");
					coin += bet;
					System.out.println("당신의 금액은 " + coin + "원 입니다.");
				}
				if ((com ==1 && select==3) || (com==2 && select==1) || (com == 3 && select ==2)) {
					System.out.println("You lose!!");
					coin -= bet;
					System.out.println("당신의 금액은 " + coin + "원 입니다.");
				}
			}
			
			String yn ="";  // 계속 할지 여부
			System.out.println();
			System.out.print("continue(y/n) : ");
			yn = sc.next();
			game.ctn(yn);
			
		}
	}
}
