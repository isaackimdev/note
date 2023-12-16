
public class Character 
	implements Action, Fight, Move{
	private String name;
	public Character(String name) {
		this.name = name;
	}
	public void walk() {
		System.out.println(name + " >> 걷다");
	}
	public void run() {
		System.out.println(name + " >> 뛰다");
	}
	public void jump() {
		System.out.println(name + " >> 점프");
	}
	public void attack() {
		System.out.println(name + " >> 공격");
	}
	public void shield() {
		System.out.println(name + " >> 방어");
	}
	public void pickup() {
		System.out.println(name + " >> 아이템을 줍다");
	}
}
