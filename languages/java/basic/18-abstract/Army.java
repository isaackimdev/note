// 추상 클래스를 상속받으면 자식은 부모의 모든 추상 메소드를 재정의 해야 한다.
public class Army extends Unit {

	// 생성자 error 해결
	public Army(String name) {
		super(name);
	}

	@Override	// 생략도 가능은 합니다. @Override 되었다는 것을 강조하기 위한 명령어
	public void attack() {
		System.out.println(getName() + " >> 육상공격");
	}

	@Override
	public void move() {
		System.out.println(getName() + " >> 육상이동");
	}
	
}
