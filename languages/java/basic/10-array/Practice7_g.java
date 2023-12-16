import java.util.Scanner;

public class Practice7_g {
	static void input_computer(int[] computer) {
		int min = 1;
		int max = 9;
		boolean chk = false; // 중복 검사용
		computer[0] = (int)(Math.random() * (max - min + 1) + min);
		for(int a=1; a<computer.length; ) {
			computer[a] = (int)(Math.random() * (max - min + 1) + min);
			chk = false;
			// 중복검사
			for(int b=0; b<a; b++) {
				if(computer[a]==computer[b]) {
					chk = true;
					break;
				}
			}
			if(!chk) a++;
		}
	}
	static int input_player() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력 : ");
		int num = sc.nextInt();
		return num;
	}
	static void end(int num) {
		if(num == 000) {
			System.out.println("종료합니다.");
			System.exit(0);
		}
	}
	static int[] play(int[] computer, int[] my, int num, int strike, int ball) {
		// 입력값을 my배열에 저장
		int n100 = num / 100;	// 123 => 1
		int m = num % 100;		// 123 => 23
		int n10 = m / 10;		// 23 => 2
		int n1 = m % 10;		// 23 => 3
		my[0] = n100;
		my[1] = n10;
		my[2] = n1;
		// 스트라이크, 볼 구분해서 카운트하기
		for(int a=0; a<computer.length; a++) {	// 기준
			for(int b=0; b<my.length; b++) {	// 비교
				if(computer[a] == my[b]) {		
					if(a == b) {	// 스트라이크
						strike++;
					} else {		// 볼
						ball++;
					}						
				} 
			}
		}
		//System.out.println(""+computer[0]+computer[1]+computer[2]);			
		//System.out.println(strike + "스트라이크 " + ball + "볼\n");
		if(strike >= 3) {
			if(ball == 4) ball--;	// 스트라이크에 우선권 부여				
			System.out.println(3 + "스트라이크 " + ball + "볼\n");
			System.out.println("스트라이크 아웃!!");
			end(000);
		} else {
			System.out.println(strike + "스트라이크 " + ball + "볼\n");              
		}
					
		if(ball >= 4) {
			System.out.println("포볼입니다.!!");
			end(000);
		}
		
		int[] result = {strike, ball};
		return result;
	}
	public static void main(String[] args) {
		// 선언		
		int[] computer = new int[3];
		int[] my = new int[3];
		int num = 0;	
		int strike = 0, ball = 0;			
		// 입력
		// 컴퓨터에 데이터 저장
		input_computer(computer);
		// 연산
		// 출력
		System.out.println("게임을 시작합니다.");
		System.out.println("(000 입력시 종료)\n");
		
		while(true) {			
			num = input_player();
			end(num);
			int[] result = play(computer, my, num, strike, ball);
			strike = result[0];
			ball = result[1];
		}
	}

}












