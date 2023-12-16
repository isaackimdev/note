import java.util.Scanner;

public class Practice6_2 {

	static int input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		return num ;
	}
	static int[] sort(int a1, int a2, int a3){
		int temp = 0 ;
		if(a1 > a2) {	// 첫번째수와 두번째수 비교
			temp = a1;
			a1 = a2;
			a2 = temp;
		}
		if(a1 > a3) {	// 첫번째수와 세번째수 비교
			temp = a1;
			a1 = a3;
			a3 = temp;
		}
		if(a2 > a3) {	// 첫번째수와 세번째수 비교
			temp = a2;
			a2 = a3;
			a3 = temp;
		} 
		int[] a = {a1, a2, a3};
		return a;
	}
	static void output(int a1, int a2, int a3){
		System.out.println(a1 + " " + a2 + " " + a3);
	}
	public static void main(String[] args) {
		// 선언
		int a1=0, a2=0, a3=0;
		// 입력
		a1 = input();
		a2 = input();
		a3 = input();
		// 연산
		int[] a = sort(a1, a2, a3);
//		sort(a1, a2, a3, temp);
		a1= a[0];
		a2 = a[1];
		a3 = a[2];
		// 출력
		output(a1, a2, a3);
		//선택정렬 알고르즘,  소팅
		
	}

}
