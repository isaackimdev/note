import java.util.Scanner;
public class Practice2 {
	static int input(String str){
		Scanner sc = new Scanner(System.in);
		System.out.print( str + " : ");
		int aa = sc.nextInt();
		return aa;
		}
	static void end(int y) {
		if(y==0) {
			System.out.println("종료되었습니다.");
			System.exit(0); // 프로그램 종료
		}
	}
	static int calc_days(int y, int[] year, int mon, int day, int num){
		if((y%4==0) && (y%100 !=0 )||(y%400==0)) {	//윤년일 때
			year[2] = 29;
		} else {	// 평년일 때
			year[2] = 28;
		} 
		for(int x=1; x<mon; x++) {
			num += year[x];
		}
		num = num+day;
		return num;
	}
	static void output (int y, int mon, int day, int num){
		System.out.printf("%d년도의 1월1일부터 %d월%d일까지는 %d일 입니다.\n", y, mon, day, num);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] year = new int[] {0, 31, 28, 31, 30, 31,
								30,31,31,30,31,30,31};
		int y=0,mon=0,day=0,num=0;

		while(true) {
			System.out.println("*** 일수 구하기 ***");
			System.out.println("종료하려면 0을 입력하세요.");
			
			y=input("년");	
			end(y);
			mon=input("월");	
			day=input("일");	

			num=0;
			
			num = calc_days(y, year, mon, day, num);
			output(y, mon, day, num);
		}
	}

}
