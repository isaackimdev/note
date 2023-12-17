import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Swing26 extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton button1 = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	
	// 생성자
	public Swing26( ) {
		setTitle("swing");
		setSize(300, 200);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		container.setLayout(new BorderLayout());
		
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.blue);
		
		
		container.add("Center", button1);
	}

	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	// 이벤트 처리
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			container.remove(button1);			// 업애기
			container.invalidate();				// 무효화
			
			container.add("Center", button2);	// 추가
			container.revalidate();				// 유효화
			
			container.repaint();				// 화면 갱신
		} else if (e.getSource() == button2) {
			container.remove(button2);			// 없애기
			container.invalidate();				// 무효화
			
			container.add("Center", button1);	// 추가
			container.revalidate();				// 화면 갱신
			
			container.repaint();				// 화면 갱신
		}
	}
}
public class Exam26 {

	public static void main(String[] args) {
		Swing26 swing26 = new Swing26();
	}

}
