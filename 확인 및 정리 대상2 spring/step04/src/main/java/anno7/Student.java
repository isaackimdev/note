package anno7;

import lombok.Data;
// lombok 사용 => 생성자, getter / setter 자동 생성됨
@Data
public class Student {
	private String name;
	private String address;
	private int age;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
}
