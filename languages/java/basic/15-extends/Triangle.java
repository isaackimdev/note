
public class Triangle {
	Area area = new Area();
	
	void setArea(double base, double height){
		area.setBase(base);
		area.setHeight(height);
	}
	
	public double getArea(){	// »ï°¢Çü ³ĞÀÌ ¸®ÅÏ
		return area.getBase() * area.getHeight() / 2;
	}	
}
