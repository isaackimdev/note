public class Monster implements Fight, Move{
	private String name;
	public Monster(String name) {
		this.name = name;	
	}
	@Override
	public void walk() {
		System.out.println(name + " >> 걷습니다.");
	}
	@Override
	public void run() {
		System.out.println(name + " >> 뜁니다.");
	}
	@Override
	public void jump() {
		System.out.println(name + " >> 점프합니다.");
	}
	@Override
	public void attack() {
		System.out.println(name + " >> 공격했습니다.");
	}
	@Override
	public void shield() {
		System.out.println(name + " >> 방어했습니다.");
	}
}