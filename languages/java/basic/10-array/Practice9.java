import java.util.Scanner;

public class Practice9 {
	public static void main(String[] args) {
		// 선언
		//-이름, 총점, 평균, 학점 저장은 1차원 배열
		//-국어, 영어, 수학, 점수 저장은 2차원 배열
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3] ;				// 이름
		int [][] sco = new int[3][3];				// 국어, 영어, 수학
		int [] sum = new int[name.length] ; 		// 총점
		double [] avg = new double[name.length] ;	// 평균
		char[]	grade;								// 학점
		
		// 입력
		// 연산
		// 총점, 평균 구하기
		for(int x=0; x<name.length; x++) {
			System.out.print("이름 : ");
			name[x]=sc.next();
			System.out.print("국어 : ");
			sco[x][0]=sc.nextInt();
			System.out.print("영어 : ");
			sco[x][1]=sc.nextInt();
			System.out.print("수학 : ");
			sco[x][2]=sc.nextInt();
			System.out.println();
			
			sum[x] = sco[x][0] + sco[x][1] + sco[x][2];
			avg[x] = (double)(sum[x] / name.length) ; 
		}
		// 학점 구하기
		// 출력
		System.out.println("--------------------------------");
		System.out.println("  이름   국어   영어   수학   총점   평균   학점");
		System.out.println("--------------------------------");
			for(int x=0; x<name.length; x++) {	
			System.out.println(name[x]+" "+sum[x]+" "+avg[x]);
			}
		System.out.println("--------------------------------");
	}

}
