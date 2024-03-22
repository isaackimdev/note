package sample2;
//02. 다형성을 이용해서 결합도를 낮춤
public class HelloSpring {
	public static void main(String[] args) {
		// 다형성을 이용해서 의존 관계를 약하게 설정(결합도를 낮춤)
		MessageBean bean = new MessageBeanKr();
		bean.sayHello();
		
	}
}
