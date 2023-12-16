
public class Practice1 {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		r.setArea(10.5 , 20.5);
		t.setArea(5.0, 9.0);
		
		System.out.println("»ç°¢ÇüÀÇ ³ĞÀÌ : " + r.getArea());
		System.out.println("»ï°¢ÇüÀÇ ³ĞÀÌ : " + t.getArea());
		
	}
}
