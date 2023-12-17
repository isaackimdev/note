import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event2 extends Frame implements ActionListener{
	Button button;
	// Frame 클래스 초기화
	public Event2() {	// Event2 this 
		button = new Button("확인");
		// Frame 설정
		setTitle("Event Listener 상속 이용");
		setSize(300,200);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면 구성
	private void init() { // init (Event2 this)
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100,100,80,30);
		add(button);
	}
	// 이벤트 설정 -- 자기자신, 상속받은 클래스르 줌
	private void start() { // start (Event2 this)
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
public class Exam2 {

	public static void main(String[] args) {
		Event2 event2 = new Event2();
	}

}

