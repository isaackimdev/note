package anno3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("anno3/bean1.xml");
		MyFoodMgr myFood = context.getBean("myFood", MyFoodMgr.class);
		System.out.println(myFood.toString());
	}
}
