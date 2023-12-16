/*
 * if-else 를 이용하여 주민번호 7번째 자리를 입력받은 후,
 * 몇 년대, 성별을 출력하세요. (ex:880101-1234567)
 * 1 : 1900년대 남성
 * 2 : 1900년대 여성
 * 3 : 2000년대 남성
 * 4 : 2000년대 여성
 * 결과
 * 주민번호 7번째 자리를 입력하세요 : 1
 * 당신은 1900년대생 남성이십니다.
 * 
 */

import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num = 0;
		// 입력
		System.out.print("주민번호 7번째 자리를 입력");
		num = sc.nextInt();
		// 연산
		// 출력
		if(num == 1) {
			System.out.println("1900년대 남성");
		} else if (num == 2){
			System.out.println("1900년대 여성");
		} else if (num == 3){
			System.out.println("2000년대 남성");
		} else if (num == 4){
			System.out.println("2000년대 여성");
		} 
	}
}
