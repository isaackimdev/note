
public class Navy extends Unit {
	public Navy(String name) {
		super(name);
	}
	@Override
	public void attack() {
		super.attack();
		System.out.println(getName() + ">> 어뢰 발사 !!");
		System.out.println(getName() + ">> 지상 상륙");
	}
	public void nucleus() {
		System.out.println(getName() + ">> 핵미사일 ");
	}
}
