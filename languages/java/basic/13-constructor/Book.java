
public class Book {
	private String subject;			//private 밖에서 접근을 못하게 막음
	private String content;
	// 생성자 ==> 객체가 생성될 떄, 자동으로 실행되는 특수한 메소드
	// 특징 : 리턴형을 명시하지 않는다. 클래스와 이름이 동일하다.
	
	Book(){ // 생성자 함수 return 및 (리턴값)자료형 정의 불가
		System.out.println("------- 생성자1 실행됨 --------");
		this.subject = "JAVA 입문";
		this.content = "JAVA는 어쩌구 저쩌구...";
	}
	
	// 파라미터가 존재하는 생성자
	// 파라미터에 의해서 멤버변수의 값을 초기화 한다.
	Book(String subject, String content){
		System.out.println("------- 생성자2 실행됨 --------");
		this.subject = subject;
		this.content = content;
	}
	void read() {
		System.out.println("-------read() 실행됭 ------");
		System.out.println(this.subject);
		System.out.println(this.content);
	}
}
