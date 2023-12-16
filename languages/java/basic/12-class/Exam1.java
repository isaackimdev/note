class Student{
	String name = "홍길동";
	int age = 25;
}

public class Exam1 {

	public static void main(String[] args) {
		/** 객체의 선언과 할당의 분리 */
		
		Student st1;
		st1 = new Student();
		System.out.println("이름 : " + st1.name);
		System.out.println("나이 : " + st1.age);
		
		/** 객체의 생성 (일괄지정) */
		Student st2 = new Student();
		st2.name = "고길동";
		st2.age = 23 ;
		System.out.println("이름 : " + st2.name);
		System.out.println("나이 : " + st2.age);
		
	}

}
