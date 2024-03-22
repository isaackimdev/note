package anno1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverCar {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("anno1/bean.xml");
		// Tire tire = (Tire)context.getBean("test"); 와 동일
		Tire tire = context.getBean("test", Tire.class);
		System.out.println(tire.getBrand());
		
		Car carTire = context.getBean("carTire", Car.class);
		carTire.driver();
		
		Car car = context.getBean("car", Car.class);
		car.driver();
		
		context.close();
	}
}







