package aop02;

public class Woman implements Person{
	// 핵심 관심사항
	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜고 Shopping을 시작한다.");
	}
	public void test(){
		System.out.println("test woman");
	}

}
