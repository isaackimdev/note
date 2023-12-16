
public class Circle implements Shape{

	@Override
	public void onDraw() {
		System.out.println("   원을 그린다.");
	}

	@Override
	public void onDelete() {
		System.out.println("   원을 지운다.");
	}

}
