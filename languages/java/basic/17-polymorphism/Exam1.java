class Living {
	void live() {System.out.println("살아있다.");}
	void breath() {System.out.println("Living : 산소로 호흡한다.");}
	void bringingup() {System.out.println("Livving : 젖으로 새끼를 양육한다.");}
	}
	
class Animal extends Living {
	void breath() {System.out.println("산소로 호흡한다.");}
	void move() {System.out.println("움직인다");}
}
class Mammalia extends Animal {
	void bringingup() {System.out.println("젖으로 새끼를 양육한다.");}
	void walk() {System.out.println("네발로 걷는다.");}
}

public class Exam1 {
	public static void main (String[] args) {
		
		
		// Mammalia 클래스 사용법 1. 자식 2. 부모
		Living r3 = new Mammalia();
		r3.live();
		r3.bringingup();
		
		Mammalia m1 = new Mammalia();
		m1.bringingup();
		m1.walk();
		m1.live();
		m1.breath();
		
		
		// Animal 클래스 사용법 1. 자식 2. 부모 
		Living r2 = new Animal();	// 부모 기준 다형성 클래스
		r2.live();
		r2.breath();
		
		Animal a1 = new Animal();
		a1.breath();
		a1.move();
		
		Living r1 = new Living();
		r1.live();
		
	}
}
