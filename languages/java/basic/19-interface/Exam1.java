public class Exam1 {
	public static void main(String[] args) {
		Character ct = new Character("주인공");
		ct.walk();
		ct.run();
		ct.jump();
		ct.attack();
		ct.shield();
		
		System.out.println("-------------------");
		
		Monster m = new Monster("악당");
		m.walk();
		m.run();
		m.jump();
		m.attack();
		m.shield();
		
		
	}
}
