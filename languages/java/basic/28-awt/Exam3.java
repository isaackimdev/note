import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

class Form3 extends Frame {	// Frame 을 상속받은 Form3
	// 화면을 꾸며줄 컴퍼넌트들을 선언해줄 것.
	// 선언 : 컴퍼넌트 객체 선언
	// 컴퍼넌트 : Frame 클래스를 꾸미는 클래스
	private Button button;
	
	public Form3() {
		button = new Button("확인");
		super.setTitle("기본화면");		// 상속받았기 때문에 Frame 클래스의 메소드를 사용 함
		super.setSize(300, 200);		// super.이 생략되어 있으며, this. 으로 써도 사용이 가능하다.
	
		init();
		start();
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		// 화면분할에 Layout을 사용하지 않겠다.
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100,100,80,30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		
	}
	
}
public class Exam3 {
	
	public static void main(String[] args) {
		
		Form3 form3 = new Form3();
		
	}
	
}
