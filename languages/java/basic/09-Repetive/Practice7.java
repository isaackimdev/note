import java.util.Scanner;

public class Practice7 {

	public static void main(String[] args) {
		// 선언 : 변수 만들기
		Scanner sc = new Scanner(System.in);
		int mid=0;			// 중간
		int last=0;			// 기말
		int sub=0; 			// 레포트report, 
		int chul=0;			// 출석 점수
		String hak =""; 	// 학점
		String grade="";	// 평가
		double r1=0;		// ( 중간 + 기말 )선언
		double r2=0;	// (r1 60%) + (과제 20%)+ (출석20%)  - 성적
	
		// 입력 : 변수에 데이터 저장하기
		System.out.print("중간고사를 입력하시오 : ");
		mid = sc.nextInt();
		System.out.print("기말고사를 입력하시오 : ");
		last = sc.nextInt();
		System.out.print("과제점수를 입력하시오 : ");
		sub = sc.nextInt();
		System.out.print("출석점수를 입력하시오 : ");
		chul = sc.nextInt();
		// 연산 : 저장된 데이터 가공하기
		/*
		  <조건 1>
		  (중간 + 기말) / 2 	===> 60%
		     과제 				===> 20%
		     출석				===> 20%
		 */
		r1 = (mid+last) /2;
		r2 = ((r1*60)+(sub*20)+(chul*20))/100 ;		// 조건1 반영  r2 = 성적
		// 출력 : 결과값 확인하기
			   if (r2 >=90) {
			System.out.printf("성적= %.2f\n", r2);
			System.out.print("학점="+'A');
		} else if (r2 >=80) {
			System.out.printf("성적= %.2f\n", r2);
			System.out.print("학점="+'B');
		} else if (r2 >=70) {
			System.out.printf("성적= %.2f\n", r2);
			System.out.print("학점="+'C');
		} else if (r2 >=60) {
			System.out.printf("성적= %.2f\n", r2);
			System.out.print("학점="+'D');
		} else {
			System.out.printf("성적= %.2f\n", r2);
			System.out.print("학점="+'F');
		}
		System.out.println();
		
		switch ((int)r2/10) {		// switch 문은 문자열을 쓸 수 있음.
			case 10 :
			case 9 :
			case 8 : System.out.println("평가 = excellent");
				break;
			case 7 :
			case 6 : System.out.println("평가 = good");
				break;
			default : System.out.println("평가 = poor");
		}
		
		
		
		
		// 출력
	}

}
