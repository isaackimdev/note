import java.util.Scanner;

public class Exam4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		char grade;
		
		System.out.print("점수 입력 : ");
		score = sc.nextInt();
		
		if(score >= 0 && score <=100) {
			switch (score / 10) {		// 정수 / 정수 = > 정수
			case 10 :
				
			case 9 : grade= 'A';
					break;
			case 8 : grade= 'B';
					break;
			case 7 : grade= 'C';
					break;
			case 6 : grade= 'D';
					break;
			default: grade= 'F';
			}	
		
			System.out.println(score + " 점, " + grade + " 학점 " );
		} else {
			System.out.println("점수는0~100점 사이로 입력해주세요.");
		}
	}

}
