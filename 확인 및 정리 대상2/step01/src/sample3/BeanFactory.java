package sample3;

public class BeanFactory {
	public MessageBean getBean(String beanName) {
		if(beanName.equals("kr")) {
			return new MessageBeanKr();
		} else if(beanName.equals("en")) {
			return new MessageBeanEn();
		}
		return null;
	}
}
