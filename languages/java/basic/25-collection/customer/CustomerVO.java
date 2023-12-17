// 문제1. 고객관리 프로그램을 작성하세요.
package customer;

public class CustomerVO {
	private String no;	// 고객번호
	private String name;	// 이름
	private String phone;	// 전화
	
	@Override
	public String toString() {		
		if(no== null || name == null) {
			return null;
		}
		String str = String.format("%6s, %7s, %13s",
				no, name, phone);
		return str;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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
}
