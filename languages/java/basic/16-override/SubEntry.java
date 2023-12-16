// Entry 를 상속받음(완료)
public class SubEntry extends Entry {
	String definition;				// 원어
	int year;						// 시기
	// 기본함수
	// 생성자, getter, setter
	public SubEntry(String word) {
		super(word);				// 부모 생성자 호출식
	}
	
	public SubEntry(String word, String definition, int year) {
		//SubEntry(word)호출
		this(word);					//현재함수식 외에 다른 본인 생성자 함수 호출식
		this.definition = definition;
		this.year = year;
		
	}
	void printView(){
		// 원어, 시기출력
		System.out.println("원어 : " + definition);
		System.out.println("시기 : " + year);
	}

}