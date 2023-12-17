import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// JFrame에 배경화면 넣기
class Swing30 extends JFrame {
	Container container = getContentPane();
	JButton button1 = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	JButton button3 = new JButton("버튼3");
	JPanel panel;
	
	public Swing30() {
		setTitle("배경 넣기");
		setSize(600,500);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		
		panel = new JPanel(new FlowLayout()) {
			@Override
			public void paintComponent(Graphics g) {	// 패널 자체에 그래픽클래스를 통하여 그림을 그림.
				super.paintComponent(g);
				setForeground(Color.RED);
				Image image = new ImageIcon("img/Dog.gif").getImage();
				// Scale image to size of component
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				g.drawImage(image, 0, 0, this);
				setOpaque(false);	// 투명하게
				g.drawRect(30,100,200,200);
				g.drawOval(50,100,200,200);
			}
		};
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.YELLOW);
		button3.setBackground(Color.YELLOW);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		container.add("Center", panel);
		
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Exam30 {
	public static void main(String[] args) {
		Swing30 swing30 = new Swing30();
	}
}
