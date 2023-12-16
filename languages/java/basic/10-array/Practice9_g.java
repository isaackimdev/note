import java.util.Scanner;

public class Practice9_g {
	// static final int NUM = 3;	// 전역변수 : 모든 함수가 전역 변수를 공통으로 사용할 수 있다.
	
	static void input(String[] name, int[][] jumsu, int NUM){
		Scanner sc=new Scanner(System.in);
		for(int x=0; x<NUM; x++) {			
			System.out.print("이름 : ");
			name[x] = sc.next();
			System.out.print("국어 : ");
			jumsu[x][0]=sc.nextInt();
			System.out.print("영어 : ");
			jumsu[x][1]=sc.nextInt();
			System.out.print("수학 : ");
			jumsu[x][2]=sc.nextInt();
		}
	}
	static void calculate(int NUM, int[]tot, double[] avg, int[][]jumsu, char[] grade){
		for(int x=0; x<NUM; x++ ) {
			tot[x] = jumsu[x][0] + jumsu[x][1] + jumsu[x][2];
			avg[x] = (double)tot[x] / 3;
			
			switch((int)avg[x]/10) {
			case 10 :
			case 9 : grade[x] = 'A'; break;
			case 8 : grade[x] = 'B'; break;
			case 7 : grade[x] = 'C'; break;
			case 6 : grade[x] = 'D'; break;
			default : grade[x] = 'F'; break;
			}
		}
	}
	static void output(String[] name, int[][] jumsu, int[] tot, double[] avg, char[] grade, int NUM){
		System.out.println("-------------------------------------------");
		System.out.printf(" %10s %5s %5s %5s %5s %5s\n", 
				"이름" , "국어" , "영어" , "수학" , "총점" , "평균" , "학점" );
		System.out.println("-------------------------------------------");
		for(int x=0; x<NUM; x++) {
			System.out.printf("%10s %5d %5d %5d %5d %5.1f %5s\n",
					name[x], jumsu[x][0], jumsu[x][1],jumsu[x][2],
					tot[x], avg[x], grade[x]);
		}
		System.out.println("-------------------------------------------");
	}
	public static void main(String[] args) {
		// 선언
		final int NUM = 3;
		String[] name = new String[NUM];
		int[][] jumsu = new int[NUM][3];
		int[] tot = new int [NUM];
		double[] avg = new double[NUM];
		char[] grade = new char[NUM];
		// 입력
		input(name, jumsu, NUM);
		// 연산 : 총점 , 평균 , 학점 구하기
		calculate(NUM, tot, avg, jumsu, grade);
		// 출력
		output(name, jumsu, tot, avg, grade, NUM);
	}
}
