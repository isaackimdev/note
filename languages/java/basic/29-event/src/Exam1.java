import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Listener를 상속받은 클래스를 만들어서 사용하는 방법
// 클래스를 따로 만들어서 사용함.
class ActionDefine implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);	// 시스템 종료
	}
}

class Event1 extends Frame {
	Button button;
	ActionDefine ad;
	// Frame 클래스 초기화
	public Event1() {
		button = new Button("확인");
		ad = new ActionDefine();
		// Frame 설정
		setTitle("Event 클래스 이용");
		setSize(300,200);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100,100,80,30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		button.addActionListener(ad);	// 퍼폼드가 있는 객체를 준다.
	}
}
public class Exam1 {

	public static void main(String[] args) {
		Event1 event1 = new Event1();
	}

}








