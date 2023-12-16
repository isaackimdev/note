
//정보처리기사
/*
 * 문제5. 국어, 영어, 수학 3과목의 점수를 입력받아서 합격인지 불합격인지 출력하시오. 
 * if-else문을 사용.
 * 합격은 평균이 60 이상이어야 하고, 한과목이라도 40점 미만이면 과락으로 불학격처리 한다.
 * 
 *  실행결과
 *  국어점수  : 98
 *  영어 점수 : 90
 *  수학 점수 : 85
 * 
 * 	합격
 */
import java.util.Scanner;

public class Practice5 {
	static int input(String str){
		Scanner sc = new Scanner(System.in);
		System.out.print(str+ "점수 : ");
		int aa = sc.nextInt();
		return aa;
	}
	static int calc_tot(int kor, int eng, int mat) {
		return kor+eng+mat;
	}
	static double calc_avg(int tot) {
		return tot/3;
	}
	static void output(double avg, int kor, int eng, int mat) {
		if( (avg>=60) && (kor>=40) && (eng>=40) && (mat>=40) ) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}
	public static void main(String[] args) {
		// 선언
			int kor=0, eng=0, mat=0, tot=0; // 초기화 =0 권장
			double avg;  // 정수로 받아도 됨. int avg
		// 입력
			kor = input("국어");
			eng = input("영어");
			mat = input("수학");
		// 연산
			//tot=kor+eng+math;
			//avg=tot/3;
			tot = calc_tot(kor, eng, mat);			
			avg = calc_avg(tot);
		// 출력
			 output(avg, kor, eng, mat);
	}
}
