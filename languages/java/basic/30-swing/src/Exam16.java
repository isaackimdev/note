import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing16 extends JFrame implements MouseListener {
	// 선언
	Container container = getContentPane();
	JLabel label = new JLabel("메모를 하세요");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItem1 = new JMenuItem("복사");
	JMenuItem menuItem2 = new JMenuItem("붙여넣기");
	JMenuItem menuItem3 = new JMenuItem("잘라내기");
	
	
	// 초기화 : 생성자 
	public Swing16() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		// frame Layout setting
		popupMenu.add(menuItem1);
		popupMenu.addSeparator();
		popupMenu.add(menuItem2);
		popupMenu.addSeparator();
		popupMenu.add(menuItem3);
		popupMenu.addSeparator();
		
		container.setLayout(new BorderLayout());
		container.add("North",label);
		container.add("Center",scrollPane);
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textArea.addMouseListener(this);
	}
	// 이벤트 처리
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == textArea) {
			if(e.isPopupTrigger()) {
				popupMenu.show(textArea, e.getX(), e.getY());	// 마우스 버튼 위치 	
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
public class Exam16 {
	public static void main(String[] args) {
		Swing16 swing16 = new Swing16();
	
	}
		
}
