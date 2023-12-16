
public class AirForce extends Unit {
	AirForce(String name){
		super(name);
	}
	
	public void attack() {
		System.out.println(getName() + " >> 공중공격");
	}
	public void move() {
		System.out.println(getName() + " >> 공중이동");
	}
	
}
