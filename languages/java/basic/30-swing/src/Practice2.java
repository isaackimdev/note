import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

class SwingTest2 extends JFrame implements ActionListener {
	// 선언
	Container container = getContentPane();
	JToolBar toolBar = new JToolBar();
	
	// 툴바 버튼
	JButton button1 = new JButton("1번");
	JButton button2 = new JButton(new ImageIcon("img/middle.gif"));	// new ImageIcon("img/middle.gif");
	JButton button3 = new JButton("3번");
	JButton button4 = new JButton("4번");
	
	// 패널 생성
	JTabbedPane tabbedPane = new JTabbedPane();

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	
	// 초기화
	public SwingTest2() {
		setTitle("swing");
		setSize(350, 250);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
		
	}
	// 화면 구성
	private void init() {
		// JFrame Layout Setting
		container.setLayout(new BorderLayout());
		
		// toolBar setting
		toolBar.setRollover(true);	// 마우스 올렸을 때 활성화
		toolBar.add(button1);
		toolBar.addSeparator();
		//toolBar.addSeparator(new Dimension(10, 2));
		toolBar.add(button2);
		toolBar.addSeparator();
		//toolBar.addSeparator(new Dimension(10, 2));
		toolBar.add(button3);
		toolBar.add(button4);
		container.add("North", toolBar);
		
		
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.RED);
		panel3.setBackground(Color.GREEN);
		panel4.setBackground(Color.BLUE);
		
		// tabbedPane setting 
		
		tabbedPane.add("1번 패널", panel1);
		tabbedPane.add("2번 패널", panel2);
		tabbedPane.add("3번 패널", panel3);
		tabbedPane.add("4번 패널", panel4);
		
		container.add("Center",tabbedPane);
		
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}
	// 이벤트 처리 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			tabbedPane.setSelectedIndex(0);
		} else if (e.getSource() == button2) {
			tabbedPane.setSelectedIndex(1);
		} else if (e.getSource() == button3) {
			tabbedPane.setSelectedIndex(2);
		} else if (e.getSource() == button4) {
			tabbedPane.setSelectedIndex(3);
		}
	}
	
}
public class Practice2 {

	public static void main(String[] args) {
		SwingTest2 swingTest2 = new SwingTest2();
	}

}
