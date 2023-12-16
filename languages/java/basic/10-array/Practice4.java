import java.util.Scanner;

//배열의 크기를 입력받아서 배열을 생성하고 데이터 입력후 출력하시오
/*
 * 배열 크기 :3
 * ar[0] : 25
 * ar[1] : 36
 * ar[2] : 78
 * 25 36 -78
 * 
 * 합 =xxx
 * 최대값 = xx
 * 최소값 = xx
 */
public class Practice4 {
	static int[] make_ar(){
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기 : ");
		int num = sc.nextInt();
		int[] ar = new int[num];
		return ar;
	}
	static int input (int[] ar) {
		Scanner sc = new Scanner(System.in);
		int sum = 0 ;
		for(int x=0; x<ar.length; x++) {
			System.out.print("ar["+ x +"] : " );
			ar[x] = sc.nextInt();
			sum += ar[x];		// 합구하기
		}
		return sum;
	}
	static int calculate_max (int[] ar) {
		int max = ar[0];
	
		for (int x=0; x<ar.length; x++ ) {
			if(max < ar[x]) max = ar[x];
		
			}
		return max;
		}
	static int calculate_min (int[] ar) {
		int min = ar[0];
		
		for (int x=0; x<ar.length; x++ ) {
			if(min > ar[x]) min = ar[x];
		
			}
		return min;
		}
	static void output (int[] ar, int sum, int max, int min) {
		for(int x=0; x<ar.length; x++) {
			System.out.print(ar[x]+" ");
		}
		System.out.println();
		System.out.println("합 = " + sum);
		System.out.println("최대값 = " + max);
		System.out.println("최소값 = " + min);
		
	}
	public static void main(String[] args) {
		
		// 선언
		int[] ar;				 	
		int	sum = 0, max=0, min=0;	
		// 입력
		ar = make_ar();
		sum = input(ar);
		// 연산
		// 최대값, 최소값  구하기
		max = calculate_max(ar);
		min = calculate_min(ar);
		
		// 출력
		output(ar, sum, max, min);
	}
}
