import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Swing27 extends JFrame implements MouseListener {
	Container container = getContentPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	CardLayout cardLayout = new CardLayout();	// ÁßÃ¸ Layout
	
	public Swing27() {
		setTitle("swing");
		setSize(300, 200);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(cardLayout);
		
		panel1.setBackground(Color.RED);
		panel2.setBackground(Color.BLUE);
		
		container.add(panel1, "red");
		container.add(panel2, "blue");

	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel1.addMouseListener(this);
		panel2.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panel1) {
			cardLayout.show(container, "blue");
		} else if (e.getSource() == panel2 ) {
			cardLayout.show(container, "red");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}

public class Exam27 {

	public static void main(String[] args) {
		Swing27 swing27 = new Swing27();
	}

}
