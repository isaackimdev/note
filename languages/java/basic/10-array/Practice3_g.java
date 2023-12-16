import java.util.Scanner;

public class Practice3_g {
	static void input(int NUM, int score[], int rank[]){
		Scanner sc = new Scanner(System.in);
		for(int x=0; x<NUM; x++) {
			System.out.print((x+1) + "번 점수 입력 : ");
			score[x] = sc.nextInt();
			rank[x] = 1;
		}
	}
	static void calc_rank(int NUM, int score[], int rank[]){
		for(int x=0; x<NUM; x++) {		// 기준
			for(int y=0; y<NUM; y++) { // 비교
				if(score[x] < score[y]) rank[x]++;
			}
		}
	}
	static void output(int NUM, int score[], int rank[]){
		System.out.println();
		System.out.println("*** 결과 ***");
		for(int x=0; x<NUM; x++) {
			System.out.printf("%d점 : %d등\n", score[x], rank[x]);
		}
	}
	public static void main(String[] args) {
		// 선언

		final int NUM = 5;
		int[] score = new int[NUM];
		int[] rank = new int[NUM];
		// 입력
		input(NUM, score, rank );
		// 연산
		calc_rank(NUM, score, rank);
		// 출력
		output(NUM, score, rank);
	}

}





