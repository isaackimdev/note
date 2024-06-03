package test4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. applicationContext.xml bean.xml 설정 정보를 이용해서 bean 객체를 생성한다.
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("test4/applicationContext.xml");
		// 2. bean 객체를 제공한다.
		
		SungjukImpl s = (SungjukImpl) context.getBean("sungjukImpl");
		s.calcTot();
		s.calcAvg();
		s.display();
		
		s.modify();
		s.display();
		
		context.close();
	}
}
