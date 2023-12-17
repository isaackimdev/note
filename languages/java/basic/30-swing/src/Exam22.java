import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

class Swing22 extends JFrame implements ActionListener, Runnable {
	Container container = getContentPane();
	JProgressBar progressBar =
			new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	JButton buttonStart = new JButton("Ω√¿€");
	JButton buttonStop = new JButton("∏ÿ√„");
	JLabel label = new JLabel("Progress Bar");
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	boolean progress = true;
	int num = 0;
	
	public Swing22() {
		setTitle("swing");
		setSize(300, 200);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		
		progressBar.setStringPainted(true);
		progressBar.setString("0%");
		container.add("Center",progressBar);
		
		panel.add(buttonStart);
		panel.add(buttonStop);
		container.add("South",panel);
		
	}
	
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonStart.addActionListener(this);
		buttonStop.addActionListener(this);
	}
	@Override
	public void run() {
		if(num == 100) num =0 ;
		for(int i=num; i<=100; i++ ) {
			if(!progress) break;
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			num = i;
			progressBar.setValue(i);
			progressBar.setString(i + "%");	
		}
		
		buttonStart.setEnabled(true);
		buttonStop.setEnabled(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonStart) {		// Ω√¿€ πˆ∆∞¿ª ¥©∏• ∞ÊøÏ
			progress = true;
			new Thread(this).start();	
			buttonStart.setEnabled(false);		// Ω√¿€ πˆ∆∞¿Ã ∫Ò»∞º∫»≠ µ .
			buttonStop.setEnabled(true);		// ∏ÿ√„ πˆ∆∞¿Ã »∞º∫»≠ µ .
		} else if(e.getSource() == buttonStop) {	// ∏ÿ√„ πˆ∆∞¿ª ¥©∏• ∞ÊøÏ
			progress = false;
			buttonStart.setEnabled(true);		// Ω√¿€ πˆ∆∞¿Ã »∞º∫»≠ µ 
			buttonStop.setEnabled(false);		// ∏ÿ√„ πˆ∆∞¿Ã ∫Ò»∞º∫»≠ µ 
		}
	}	
}
public class Exam22 {

	public static void main(String[] args) {
		Swing22 swing22 = new Swing22();
	}

}
