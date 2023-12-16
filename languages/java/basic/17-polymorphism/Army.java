
public class Army extends Unit {
	// 해당되는 생성자를 호출해야 합니다.
	public Army(String name) {
		super(name);
	}
	@Override
	public void attack () {
		super.attack();
		System.out.println(getName() + ">> 지상공격 실행함");
	}
	public void tank() {
		System.out.println(getName() + ">> 탱크공격");
	}
}
