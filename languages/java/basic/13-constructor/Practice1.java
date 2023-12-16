public class Practice1 {

	public static void main(String[] args) {
	
		Triangle t1 = new Triangle();
		t1.setTriangle(5, 12);
		System.out.println("»ï°¢ÇüÀÇ ³ĞÀÌ : " + t1.getArea());
		
		Triangle t2 = new Triangle(45,7);
		System.out.println("»ï°¢ÇüÀÇ ³ĞÀÌ : " + t2.getArea());
		
	}

}
