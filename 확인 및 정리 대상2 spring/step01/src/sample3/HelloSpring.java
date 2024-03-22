package sample3;
// 03. Factory 패턴을 이용해서 겹합도를 낮춤
public class HelloSpring {
	public static void main(String[] args) {
		// Factory 패턴을 이용해서 결합도를 낮춤
		BeanFactory factory = new BeanFactory();
		MessageBean bean = factory.getBean("kr");
		bean.sayHello();
	}
}
