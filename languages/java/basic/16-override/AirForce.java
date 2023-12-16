
public class AirForce extends Unit {
	public AirForce(String name) {
		super(name);
	}
	@Override
	public void attack() {
		super.attack();
		System.out.println(getName() + ">> 이륙 !!");
		System.out.println(getName() + ">> 공중공격 실행함");
	}
	public void bombing() {
		System.out.println(getName() + ">> 폭격 ");
	}
}
