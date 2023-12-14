/*
 * 문제 1. 이름이 L(name)인 사람의 기본급(basePay)이 2,500,000일때 3.3%
 * 세금(tax)과 월급(salary)을 계산하시오. 데이터는 반드시 변수에 저장하기
 * 
 * 세금 = 기본급 * 3.3%(0.033)
 * 월급 = 기본급 - 세금
 * 
 * 실행 결과
 * 
 * *** L의 월급 ***
 * 기본급 : 2,500,000원
 * 세금 : 82500원
 * 월급 : 2417500원
 */


public class Practicel {
	public static void main(String[] args) {
		// 선언
		int basePay = 2500000;
		double tax = basePay*0.033;
		// 연산
		int salary = basePay-(int)tax;
		// 출력
		System.out.println("기본급 : "+basePay+"원");
		System.out.println("세금 : "+tax+"원");
		System.out.println("월급 : "+salary+"원");
		
		
		
		
	}
}
