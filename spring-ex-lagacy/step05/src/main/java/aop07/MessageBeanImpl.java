package aop07;
// Target Bean(타겟 대상) => 핵심 관심 사항
public class MessageBeanImpl implements MessageBean {
	private String name;
	
	@Override
	public void sayHello() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello," + name + "!!");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
