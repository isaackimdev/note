import java.util.Scanner;

//문제2. 점수를 매개 변수 a에 넘겨주면 학점(A, B, C ,D ,F 중의 한 문자)을
// 돌려 줄 수 있도록 grade() 함수의 내용을 완성하시오. 이때, 함수는 static 으로 해야한다.
///////////////////////////////////////////////////////////////// 
 
public class Practice2 {
	static String grade(double a){
		switch((int)a/10) {
		case 10 :
		case 9 : return "A";
		case 8 : return "B";
		case 7 : return "C";
		case 6 : return "D";
		default : return "F";
		}
	}
	static int input_kor (  ){
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		return kor;
	}
	static int input_eng (  ) {
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		return eng;
	}
	static int input(String str){
		Scanner sc = new Scanner(System.in);
		System.out.print(str+"점수 입력 : ");
		int jumsu = sc.nextInt();
		return jumsu;
	}
	static int calc_tot (int kor , int eng) {
		return kor + eng;
	}
	static double calc_avg( int tot) {
		return (double) tot / 2;  
	}
	static void output (double avg) {
		
		System.out.println(grade(avg)+"학점입니다.");
		
	}
	public static void main(String[] args) {
	
		int kor, eng, tot;
		double avg;
		
		kor = input("국어");
		eng = input("영어");
	//	kor = input_kor();
	//	eng = input_eng();
		
		tot = calc_tot(kor, eng);
		avg = calc_avg(tot);
		
		output(avg);
	}

}
