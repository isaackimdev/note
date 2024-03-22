package sample1;
// 01. 결합도가 높은 프로그램
public class HelloSpring {
	public static void main(String[] args) {
		
		MessageBeanKr bean = new MessageBeanKr();
		bean.tellMe();	// 의존성이 높음, 한번의 수정을 할 때 코드를 여러번 수정 하는 것...
		
	}
}
