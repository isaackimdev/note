
public class Practice2 {

	public static void main(String[] args) {
		Address a1;
		a1 = new Address("홍길동","010-1234-5678", "서울시 강남구 역삼동");
		a1.showAddress();
		a1.setNum("010-7777-1111");
		a1.showAddress();	
	}
}
