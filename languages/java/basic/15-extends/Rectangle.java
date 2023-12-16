
public class Rectangle {
	Area area = new Area();
	
	void setArea(double base, double height){
		area.setBase(base);
		area.setHeight(height);
	}
	
	public double getArea(){ 	// 사각형 넓이 리턴
		return area.getBase() * area.getHeight();
	}

}
