// 생성자
public class Address {
	// 선언
	private String name ;	// 이름
	private String num ;  	// 전화번호
	private String ad ;		// 주소
	
	// private 밖에서 직접적으로 데이터 접근 불가.
	
	// 입력
	// 기본함수 : 기본적으로 사용하는 함수
	// 생성자, getter, setter 
	// 생성자 : 멤버필드 초기화
	public Address(String name, String num,String ad){
		this.name = name;
		this.num = num;
		this.ad = ad;
		
	}
	public void setName(String name) {		// setter
		this.name = name;
	}
	public void setNum(String num) {		// setter
		this.num = num;
	}
	public void setAd(String ad) {		// setter
		this.ad = ad;
	}
	// 연산
	// (내용) 출력
	public String getName() {	// getter
		return name;
	}
	public String getNum() {	// getter
		return num;
	}
	public String getAd() {	// getter
		return ad;
	}
	
	public void showAddress() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + num);
		System.out.println("주소 : " + ad);
		
	}
	
}

// 변수는 보통 private 많이 쓰고,
// 함수는 public을 많이 씀.