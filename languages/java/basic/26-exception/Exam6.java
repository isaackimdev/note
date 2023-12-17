
public class Exam6 {

	public static void main(String[] args) {
		AAA aaa = new AAA();
		try { // 사용하는 쪽에서 예외처리하고 넘기는 것 : 예외전가
			aaa.ex();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		System.out.println("--- 프로그램이 종료되었습니다. ---");
		
	}

}
