import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int guk, eng, tot; 
		double evr;
		String result="";  // 등급
		
		// 입력
		System.out.print("국어점수 입력 : ");
		guk = sc.nextInt();
		System.out.print("영어점수 입력 : ");
		eng = sc.nextInt();
		
		// 연산
		tot = guk+eng;
		evr = (double)(guk+eng)/2;
		
		
		
		if(!(evr<0 && evr>100)) {
			switch ((int)(evr/10)) {   //정수, 문자, 문자열
			case 10 : result="A+";
				break; //result="A";
			case 9 : result="A";
				break;
			case 8 : result="B";
				break;
			case 7 : result="C";
				break;
			case 6 : result="D";
				break;
//			case 5 : result="F";
//				break;
			default: result="F";
				
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
		// 출력
		System.out.println("총점 = "+tot);
		System.out.println("평균 = "+evr);
		System.out.println("학점 = "+result);
		
		
		
	}

}
