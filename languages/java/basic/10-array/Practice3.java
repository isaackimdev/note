import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// 선언 : 배열 2개
		Scanner sc = new Scanner(System.in);
		final int NUM = 5; 					// 상수는 대문자로 씀
		int[] score = new int[NUM];			// 점수 배열
		int[] rank = new int[NUM]; 			// 등수의 길이는 점수의 길이와 같음
		// 입력
		for(int x=0; x<score.length; x++ ) {		
			System.out.print((x+1)+"번 점수 입력 : ");		//점수 입력 
			score[x] = sc.nextInt();

			rank[x] = 1; // 랭크 초기화

		}
		// 연산 
		for (int x=0; x<score.length; x++ ) {			// 기준
			for (int y=0; y<score.length; y++) {		// 비교
			if (score[x] > score[y] ) rank[x]++;
			}
		}
		// 출력
		System.out.println();
		System.out.println(" *** 결과 *** ");
		for(int x=0; x<score.length; x++) {
			System.out.printf("%d점 : %등\n", score[x] , rank[x]);
		}

	}	
}
