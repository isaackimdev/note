package study.java.model;
// 비슷한 기능을 모아놓은 클래스를 Package 라고 함.
/** 주소록 데이터를 표현하기 위한 Java Beans */
public class People {
	private String name;
	private String phone;
	// 기본함수 : 생성자, getter, setter, toString
	public People () {
	}
	public People (String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	// 기본기능은 모든 멤버변수를 보여주는 용도로 사용
	@Override
	public String toString() {
		return "People [name=" + name + ", phone=" + phone + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	// 자바빈즈는
	// 1) 매개변수는 private
	// 2) 함수는 public
	// 3) getter, setter	
}




