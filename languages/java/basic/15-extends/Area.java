// java beans 의 형태.
public class Area {
	private double base;	// 밑변
	private double height;	// 높이
	
	public void setArea(double base, double height){
		// 밑변, 높이 대입
		this.base = base;
		this.height = height;
	}
	public double getBase() {
		// 밑변 리턴
		return base;
	}
	public void setBase(double base) {
		//밑변 대입
		this.base = base;
	}
	public double getHeight() {
		// 높이 리턴
		return height;
	}
	public void setHeight(double height) {
		// 높이 대입
		this.height = height;
	}
}
