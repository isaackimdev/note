package aop09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop09/applicationContext.xml");
		
		CalcMethod calc = (CalcMethod) context.getBean("calcMethod");
		calc.sum(5, 4);
		
		calc.div(5, 0);
		
		context.close();
	}
}
