
public class Exam2 {
	public static void main(String[] args) {
		Army army = new Army("육군");
		army.attack();
		army.tank();
		
		Navy navy = new Navy("해군");
		navy.attack();
		navy.nucleus();
		
		AirForce airForce = new AirForce("공군");
		airForce.attack();
		airForce.bombing();
		
	
	}
}
