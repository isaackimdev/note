import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

class Form3e extends Frame { // Frame을 상속 받은 Form3

	// 화면을 꾸며줄 컴퍼넌트들을 선언해줄 것.
	// 선언 : 컴퍼넌트 객체 선언
	// 컴퍼넌트 : Frame 클래스를 꾸미는 클래스 
	private Button button;
	
	public Form3e () {
		button = new Button(" 확으인 ");
		super.setTitle("yesMan");	// 상속받았기 때문에 Frame 클래스의 메소드를 사용 함.
		super.setSize(300 , 200);	// super. 이 생략되어 있으며, this. 으로 써도 사용 가능하다.
	
		this.init();
		this.start();
		
		setVisible(true);
	}
	// 화면 구성
	private void init(){
		setLayout(null);
		button.setBackground(Color.BLUE);
		button.setBounds(100, 100, 50, 70);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		
	}
	
}
public class Exam3_3 {	
	
	public static void main(String[] args) {
		Form3e f = new Form3e();
	}
	
}
