import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Event4 extends Frame{
	Button button;
	public Event4() {
		button = new Button("확인");
		setTitle("Event 다형성 이용");
		setSize(300, 200);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	private void start() {
		// 확인 버튼을 눌렀을 때의 처리
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		};
		button.addActionListener(al);	// 엑션 퍼폼드에 대한 객체를 주는 것!!
		// 프레임 창의 x버튼의 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
				super.windowClosing(arg0);
			}
		});
		
	}
}

public class Exam4 {

	public static void main(String[] args) {
		Event4 event4 = new Event4();
	}

}
