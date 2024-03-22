package aop01;

public class Woman {
	public void classWork() {
		System.out.println("교실문을 연다.");
		
		try {
			System.out.println("컴퓨터를 켜고 Shopping을 시작한다.");	// 핵심 관심사항 aspect
		} catch (Exception e) {
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			System.out.println("전등이 켜져있는지 확인한다.");
		}
		System.out.println("교실문을 잠근다.");
	}
}
