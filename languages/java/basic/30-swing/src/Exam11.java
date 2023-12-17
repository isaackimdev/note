import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing11 extends JFrame implements MouseListener {
	// 선언
	Container container = getContentPane();
	JLabel label = new JLabel("메모장", JLabel.CENTER);
	JButton button1 = new JButton("확인");
	JButton button2 = new JButton("취소");
	
	JTextArea textArea = new JTextArea();	// 생략시에 가운데에 위치??
	JScrollPane scrollPane = new JScrollPane(textArea);	
	// 초기화
	public Swing11() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		// container Layout setting
		container.setLayout(new BorderLayout());
		container.add("North",label);
		
		textArea.setDragEnabled(true);	 // 드래그 기능 활성화
		textArea.setFocusAccelerator('r');		// 포거스를 가져가는 기능
		textArea.setSelectedTextColor(Color.RED);	// 선택된 영역의 글자 생상 설정
		textArea.setSelectionColor(Color.YELLOW);	// 선택된 영역의 배경 색상 설정
		
		scrollPane.setWheelScrollingEnabled(true);
		container.add("Center",scrollPane);

//		container.add("Center",textArea);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(button1);
		panel.add(button2);
		container.add("South",panel);
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textArea.addMouseListener(this);
	}
	// 이벤트 처리
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == textArea) {
			if(e.getClickCount() == 2 ) {	// 더블 클릭 인식
				textArea.paste();	// 붙여넣기 기능 수행 
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == textArea) {
			if(e.isPopupTrigger()) {	// 오른쪽 마우스를 눌렀음을 인식
				textArea.copy();	// 복사 기능 수행
			}	
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
public class Exam11 {

	public static void main(String[] args) {
		Swing11 swing11 = new Swing11();
	}

}
