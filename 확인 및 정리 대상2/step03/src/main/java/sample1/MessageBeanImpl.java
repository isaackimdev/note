package sample1;

public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		
	}
	public MessageBeanImpl(String fruit) {
		this.fruit = fruit;
		System.out.println("MessageBeanImpl(String fruit) 생성자 호출 ");
	}
	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost(int cost) 호출");
	}
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost);
	}
	@Override
	public void sayHello(String a, int b) {
		System.out.println(a + "\t" + b);
	}
	
}
