import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

class Swing13 extends JFrame {
	// 선언
	Container container = getContentPane();
	BorderLayout borderLayout = new BorderLayout();
	JPanel panel = new JPanel(null);
	// JInternalFrame(title, resizable, closable, maximizable, iconifiable)
	JInternalFrame internalFrame = new JInternalFrame("제목", true, true, true, true);
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	// 초기화 : 생성자 
	public Swing13() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
		
	}
	// 화면 구성
	private void init() {
		container.setLayout(borderLayout);
		container.add("West", button1);
		container.add("South", button2);
		
		panel.add("Center", internalFrame);
		
		Container containerJIF = internalFrame.getContentPane();
		containerJIF.setLayout(new FlowLayout());
		containerJIF.add(new JButton("3"));
		containerJIF.add(new JButton("4"));
		internalFrame.setFrameIcon(new ImageIcon("img/cat.gif"));	// 타이틀 아이콘 변경
	

	
			try {
				internalFrame.setMaximum(true); 	// 기본적으로 최대 크기로 보여줄 것을 설정
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	
		
		internalFrame.setSize(100, 80);
		internalFrame.setVisible(true);
		
		container.add("Center", panel);
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// 이벤트 처리
	
}

public class Exam13 {

	public static void main(String[] args) {
		Swing13 swing13 = new Swing13();
	}

}
////////////////////////////////////////////////////////
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.beans.PropertyVetoException;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JInternalFrame;
//import javax.swing.JPanel;
//
//class Swing13 extends JFrame {
//	Container container = getContentPane();
//	BorderLayout borderLayout = new BorderLayout();
//	JPanel panel = new JPanel(null);
//	// JInternalFrame(title, resizable, closable, maximizable, iconifiable)
//	JInternalFrame internalFrame = new JInternalFrame("제목", true, true, true, true);
//	JButton button1 = new JButton("1");
//	JButton button2 = new JButton("2");
//	
//	public Swing13() {
//		setTitle("swing");
//		setSize(300, 200);
//		setLocation(300, 300);
//		init();
//		start();
//		setVisible(true);
//	}
//	private void init() {
//		container.setLayout(borderLayout);
//		container.add("West", button1);
//		container.add("South", button2);
//		
//		panel.add("Center", internalFrame);
//		
//		Container containerJIF = internalFrame.getContentPane();
//		containerJIF.setLayout(new FlowLayout());
//		containerJIF.add(new JButton("3"));
//		containerJIF.add(new JButton("4"));
//		internalFrame.setFrameIcon(new ImageIcon("img/cat.gif"));	// 타이틀 아이콘 변경
//		try {
//			internalFrame.setMaximum(true);		// 기본적으로 최대 크기로 보여줄 것을 설정
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}		
//		
//		internalFrame.setSize(100, 80);
//		internalFrame.setVisible(true);
//		container.add("Center", panel);
//	}
//	private void start() {
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}	
//}
//public class Exam13 {
//	public static void main(String[] args) {
//		Swing13 swing13 = new Swing13();
//	}
//}