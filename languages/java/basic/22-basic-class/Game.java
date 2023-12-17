import java.util.Scanner;

public class Game {
	public void menu(){
		System.out.println("1.가위");
		System.out.println("2.바위");
		System.out.println("3.보");
		System.out.println("0.프로그램 종료\n");
	}
	public String selectResult(int select){
		String Mresult = "";
		if (select == 1) {
			Mresult = "가위";
		} else if (select == 2 ) {
			Mresult = "바위";
		} else if (select == 3 ) {
			Mresult = "보";
		}
			return Mresult;
	}
	public String com (int com) {
		String Cresult = "";
		if (com == 1) {
			Cresult = "가위";
		} else if (com == 2) {
			Cresult = "바위";
		} else if (com == 3) {
			Cresult = "보";
		}
		return Cresult;
	}
	
	public void Routput (String Cresult, String Mresult) {
			System.out.println("computer : " + Cresult + " you : " + Mresult);
	}

	public void ctn (String yn) {
		Scanner sc = new Scanner(System.in);
		int bet = 0 ;
		if(yn =="n") {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		} else if (yn == "y") {
			System.out.println("insert coin : ");
			bet = sc.nextInt();
			System.out.println("충전되었습니다.");
			System.out.println("-------NEW-------");
		}
	
	}
	
}
	
	

