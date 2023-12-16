import java.util.Random;
import java.util.Scanner;

// 1. 번호만들기
// 2. 번호 정렬하기 sort
public class Lotto {
	// 선언
	int[] m;	// 로또번호 : 1~45, 6개
	int buyNum;	// 구매횟수
	// 입력
	Lotto () {
		m = new int[6];
		buyNum = 0;
	}
	public void inputBuyNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("구매횟수를 입력하세요 : ");
		buyNum = sc.nextInt();
		System.out.println();
	}
	// 연산
	// 1. 번호 만들기
	public void selectLotto() {
		boolean chk;
		Random random = new Random();
		
		for(int i=0; i<buyNum; i++) {	// 구매횟수만큼 반복
			m[0] = random.nextInt(45) + 1; // 1~45 사이의 임의정수 1개 생성
			for(int a=1; a<6;) {	// 나머지 5개 번호 저장, 중복검사
				m[a] = random.nextInt(45) + 1;
				// 중복검사
				chk = false;
				for(int b=0; b<a; b++ ) {
					if (m[a] == m[b] ) {
						chk = true;
						break;
					}
				}
				
				if(!chk) a++;	// 번호가 겹치지 않으면, a 값 증가
			}
			sort();
			outputResult();
		}
	}
	// 선택정렬 : sort + ~ing
	public void sort() {
		for(int x=0; x<5; x++) {		// 기준
			for(int y=x+1; y<6; y++ ) {	// 비교
				if( m[x] > m[y] ) {
					int temp = m[x];
					m[x] = m[y];
					m[y] = temp;
				}
			}
		}
	}
	// 출력
	public void outputResult(){
		System.out.printf("%2d %2d %2d %2d %2d %2d\n",
				m[0], m[1], m[2], m[3], m[4], m[5]);
	}
	
}
