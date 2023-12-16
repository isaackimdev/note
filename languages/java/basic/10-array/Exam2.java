// 2차원 배열
public class Exam2 {

	public static void main(String[] args) {
		// 학급 성적을 위한 배열
		int [][] grade = new int[3][3];
		String[] name = {"홍길동", "김철수","이영희"};
		// 홍길동의 과목별 점수
		grade[0][0] = 75;
		grade[0][1] = 82;
		grade[0][2] = 95;
		// 김철수의 과목별 점수
		grade[1][0] = 88;
		grade[1][1] = 64;
		grade[1][2] = 70;
		// 이영희의 과목별 점수
		grade[2][0] = 100;
		grade[2][1] = 95;
		grade[2][2] = 90;
		/** 2차 배열을 탐색하여 총점과 평균점수 구하기 */
		for(int i = 0 ; i<grade.length; i++) {		// 행
			// 반복문 안에서 선언된 변수는 매 실행시마다 새로 생성된다.
			int sum =0;
			int avg =0;
			// 총점 계산
			for (int j=0; j<grade.length; j++) {	// 열
				sum +=grade[i][j];							
			}
			avg = sum / grade[i].length;	// sum / 3;
			
			System.out.println(name[i]+", 총점="+sum+", 평균="+avg);
		}
	}

}
