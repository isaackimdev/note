import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 선언
		String name="";
		int kor=0, eng=0, mat=0, tot=0;
		double avg=0;
		// 입력
		System.out.print("이름?");
		name = sc.next();
		System.out.print("국어?");
		kor = sc.nextInt();
		System.out.print("영어?");
		eng = sc.nextInt();
		System.out.print("수학?");
		mat = sc.nextInt();  
		// 정수는  nextInt 로 받을 수 있고 실수는 nextDouble 로 받을 수 있음
		// 연산
		tot = kor + eng + mat;
		avg = (double)tot / 3;
		// 출력
		/* 문자열 : %s
		 * 정수 : %2d <= 숫자는 자릿수
		 * 실수 : %3.1f <= 앞자리 숫자는 자릿수, 뒷자리 숫자는 소수점 자리수
		 */
		System.out.printf("이름: %s\n국어: %d\n 영어: %d\n"
				+ "수학: %d\n총점: %d\n평균: %.1f\n",
				name, kor, eng, mat, tot, avg, args);
//		System.out.println("이름:"+name);
//		System.out.println("국어:"+kor);
//		System.out.println("영어:"+eng);
//		System.out.println("수학:"+mat);
//		System.out.println("총점:"+tot);
//		System.out.println("평균:"+avg);

	}
}
