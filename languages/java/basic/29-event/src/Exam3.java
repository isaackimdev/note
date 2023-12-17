import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event3 extends Frame {
	Button button;	
	// Frame 클래스 초기화
	public Event3() {	
		button = new Button("확인");
		// Frame 설정
		setTitle("Event 익명 중첩 클래스 이용");
		setSize(300, 200);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 	// arg0
				System.exit(0);
				
			}
		});
	}
}
public class Exam3 {

	public static void main(String[] args) {
	Event3 event3 = new Event3();
	}

}



