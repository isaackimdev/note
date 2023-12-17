import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class Swing17 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("이것은 탭 팬입니다.");
	JButton button1 = new JButton("확인");
	JButton button2 = new JButton("취소");
	
	JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel panel2 = new JPanel(new BorderLayout());
	// 아래쪽에 표시되는 탭 Pane을 선언
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	JButton btn1 = new JButton("첫번째 Tab");
	JButton btn2 = new JButton("두번째 Tab");
	JButton btn3 = new JButton("세번째 Tab");
	JButton btn4 = new JButton("네번째 Tab");
	JButton btn5 = new JButton("다섯번째 Tab");
	
	
	// 초기화 : 생성자 
	public Swing17() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		
		panel1.add(button1);
		panel1.add(button2);
		container.add("South",panel1);
		
		tabbedPane.add(btn1);
		tabbedPane.add(btn2);
		tabbedPane.add(btn3);
		tabbedPane.add("Title", btn4);
		// 이미지와 함께 탭 추가
		tabbedPane.addTab("Title", new ImageIcon("img/middle.gif"), btn5,
				" 여긴 아이콘이 있습니다.");
		panel2.add("Center",tabbedPane);
		container.add("Center",panel2);
		// 세번째 탭에 빨간색 배경 설정
		tabbedPane.setBackgroundAt(2, Color.RED);
		// 다섯번째 탭의 첫 번째 글자에 밑줄 긋기
		tabbedPane.setDisplayedMnemonicIndexAt(4,0);
		// 세번째 탭 비활성화
		tabbedPane.setEnabledAt(2, false);
		// 다섯번째 탭의 글자색을 파란색으로 설정
		tabbedPane.setForegroundAt(4, Color.BLUE);
		// 네번째 탭에 단축키로 'A' (ASCII : 65) 설정
		tabbedPane.setMnemonicAt(3, 65);			//nemonic 은 단축키 입니다
		// 첫번째 탭의 글자를 "text"로 변경
		tabbedPane.setTitleAt(0, "Test");
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// 이벤트 처리
	
}

public class Exam17 {
	public static void main(String[] args) {
		Swing17 swing17 = new Swing17();
	}
}
