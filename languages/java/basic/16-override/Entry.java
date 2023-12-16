
public class Entry {
	String word;	// 약어 저장
	
	Entry(){
		System.out.println("***약어사전***");
	}
	
	Entry(String word){
		this(); 	// 자시 자신의 다른 생성자 호출>출력
		this.word = word;
	}
	
	void writeView(){
		// 약어 출력
		
		System.out.println("약어 : " + word );
	}
}
