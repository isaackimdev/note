package anno2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("anno2/bean2.xml");
		MyFoodMgr myFood = context.getBean("myFood", MyFoodMgr.class);
		System.out.println(myFood.toString());

		context.close();
	}
}
