import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2 {
	public static void main(String[] args) throws IOException {
		// 선언 : 변수만들기
		String name = "";
		int kor=0, eng=0, mat=0, tot=0;
		double avg=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 : 변수에 데이터 저장하기
		System.out.print("이름?");
		name = br.readLine();  // br.readLine(); > (\n 엔터) 앞까지 불러옵니다.
		System.out.print("국어?");
		// Integer.parselnt (숫자만으로 된 문자열) => 문자열을 정수로 변환시켜줌
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("영어?");
		eng = Integer.parseInt(br.readLine());
		
		
		System.out.print("수학?");
		mat = Integer.parseInt(br.readLine());
		
		// 연산 : 저장된 데이터 가공하기
		tot = kor + eng + mat;
		avg = (double)tot/3;
		// 출력 : 가공된 결과 확인하기
		System.out.println("이름:" + name);
		System.out.println("국어:" + kor);
		System.out.println("영어:" + eng);
		System.out.println("수학:" + mat);
		System.out.println("총점:" + tot);
		System.out.println("평균:" + avg);
		
	}
}

