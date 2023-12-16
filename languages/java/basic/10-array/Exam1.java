//	1	int[] a = new int[3];
//	2	int[] b;
//		b=new int[2];
//	3	int[] c = {1, 2, 3};



// 홍길동=84
// 김철수=74
// 이영희 =95
public class Exam1 {

	public static void main(String[] args) {
	
		/** 배열의 생성 방법*/
		// 배열의 선언과 크기 지정 및 값의 할당에 대한 개별 처리
		int [] hong;
		hong = new int[3];
		hong[0] = 75;
		hong[1] = 82;
		hong[2]	= 95;
		// 배여르이 선언과 크기 지정의 일괄처리
		int []kim = new int[3];
		kim[0] = 88;
		kim[1] = 64;
		kim[2] = 70;
		// 배열 생성의 일괄처리
		// int[] lee = new int[] {100, 95, 90};
		int lee[] = {100, 95, 90};
		// 각 배열요소의 값에 대한 합계 구하기
		int [] sum = {0, 0, 0};
		for(int i=0; i<hong.length; i++) {
			sum[0] += hong[i];
		}
		for(int i=0; i<kim.length; i++) {
			sum[1] += kim[i];
		}
		for(int i=0; i<lee.length; i++) {
			sum[2] += lee[i];
		}
		// 배열의 전체 길이로 나누어, 평균을 출력한다.
		System.out.println("홍길동 =" + sum[0]/hong.length);
		System.out.println("김철수 =" + sum[1]/kim.length);
		System.out.println("이영희 =" + sum[2]/lee.length);
		
		
	}
}
