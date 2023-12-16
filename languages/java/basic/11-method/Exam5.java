import java.util.Scanner;

public class Exam5 {
	
	static final int NUM = 5;   // 변수의 상수화
	
	
	static void inputNum(int[] a){
			
		Scanner sc = new Scanner(System.in);
		for (int x=0; x<NUM; x++ ) {
			System.out.print((x+1)+"번쟤 숫자 입력 : ");
			a[x] = sc.nextInt();
		}
	}
	
	static void outputNum(int[] a){
		System.out.println("\n*** 출력 ***");
		for (int x=0; x<NUM; x++ ) {
			System.out.print(a[x]+" ");
		}
	}
	
	public static void main(String[] args) {


		int []n = new int [NUM] ;
		
		inputNum(n);
		outputNum(n);
		

		
		
	}

}
