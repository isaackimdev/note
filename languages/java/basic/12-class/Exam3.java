class HelloWorld {
	String message;
	void setEng() {
		message = "hello Java";
	}
	
	void setKor() {
		message = "안녕하세요. 자바"; 
	}
	void sayHello() {
		System.out.println(message);
	}
	
}



public class Exam3 {

	public static void main(String[] args) {
		
		HelloWorld helloWorld = new HelloWorld();
		
		helloWorld.setEng();
		helloWorld.sayHello();
		
		helloWorld.setKor();
		helloWorld.sayHello();

	}

}
