
public class Rectangle implements Shape {

	@Override
	public void onDraw() {
		System.out.println("   사각형을 그린다.");
	}

	@Override
	public void onDelete() {
		System.out.println("   사각형을 지운다.");
	}

}
