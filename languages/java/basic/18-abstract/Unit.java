/** 육군/해군/공군 의 공통 기능을 명시하기 위한 부모클래스 */
public abstract class Unit {
	private String name;
	
	public Unit(String name) {
		this.name = name;
	}
	// 자식들이 재정의할 메소드를 abstract 로 명시
	public abstract void attack();	// new 로 만들 수 없는 클래스, 함수
	public abstract void move();	// 상속받을 자식 클래스에 필수적으로
									// 함수를 만들게 하기 위해.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
