package anno4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SchoolMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("anno4/bean.xml");
		School school = context.getBean("mySchool",School.class);
		System.out.println(school.toString());
		context.close();
	}
}
