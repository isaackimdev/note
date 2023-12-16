import java.util.Scanner;

public class Practice1 {
	
	static final int NUM = 5;
	
	static int input(int[] sco){
		Scanner sc = new Scanner(System.in);
		int tot = 0;
		for (int i = 0 ; i<sco.length; i++) {
			System.out.print((i+1)+"번 학생의 점수를 입력 : ");
			sco[i] = sc.nextInt();
			tot += sco[i];
		}
		return tot;
	}
	static double calc_avg(int tot) {
		return (double)tot/NUM;
	}
	static void output(int tot, double avg) {
		System.out.println();
		System.out.print("총점:"+ tot +", ");
		System.out.print("평균 :"+ avg);
	}
	public static void main(String[] args) {
		// 선언
		int[] sco = new int[NUM];	// 개별 학생의 점수  [배열]
		int tot = 0;			// 점수 합계 
		double avg = 0;			// 평균
		// 입력
		tot = input(sco);
		// 연산
		avg = calc_avg(tot);
		// 출력 
		output(tot, avg);
		
		

		
	}

}
