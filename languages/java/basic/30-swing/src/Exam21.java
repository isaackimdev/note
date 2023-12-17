import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Swing21 extends JFrame implements ChangeListener {
	Container container = getContentPane();
	JSlider sliderRed = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider sliderGreen = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider sliderBlue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	
	JLabel labelRGB = new JLabel("RGB(0, 0, 0)", JLabel.CENTER);
	JLabel labelRed = new JLabel("RED");
	JLabel labelGreen = new JLabel("GREEN");
	JLabel labelBlue = new JLabel("BLUE");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel(new BorderLayout());
	JPanel panelWest = new JPanel(new GridLayout(0, 1));
	JPanel panelCenter = new JPanel(new GridLayout(0, 1));
	
	int r, g, b;	
	
	public Swing21() {
		setTitle("swing");
		setSize(400, 250);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		
		sliderRed.setMajorTickSpacing(50);	// 슬라이드의 주 눈금 간격 지정
		sliderRed.setMinorTickSpacing(5);	// 슬라이드의 보조 눈금 간격 지정
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		
		sliderGreen.setMajorTickSpacing(50);	// 슬라이드의 주 눈금 간격 지정
		sliderGreen.setMinorTickSpacing(5);	// 슬라이드의 보조 눈금 간격 지정
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		
		sliderBlue.setMajorTickSpacing(50);	// 슬라이드의 주 눈금 간격 지정
		sliderBlue.setMinorTickSpacing(5);	// 슬라이드의 보조 눈금 간격 지정
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		
		labelRed.setForeground(Color.RED);
		labelGreen.setForeground(Color.GREEN);
		labelBlue.setForeground(Color.BLUE);
		labelRGB.setFont(new Font("돋음체", Font.BOLD, 24));
		
		panelWest.add(labelRed);
		panelWest.add(labelGreen);
		panelWest.add(labelBlue);
		
		panelCenter.add(sliderRed);
		panelCenter.add(sliderGreen);
		panelCenter.add(sliderBlue);
		
		panel1.setBackground(new Color(0, 0, 0));
		panel2.add("West", panelWest);
		panel2.add("Center", panelCenter);
		
		container.add("North", labelRGB);
		container.add("Center", panel1);
		container.add("South", panel2);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sliderRed.addChangeListener(this);
		sliderGreen.addChangeListener(this);
		sliderBlue.addChangeListener(this);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == sliderRed) {
			r = sliderRed.getValue();
		} else if(e.getSource() == sliderGreen) {
			g = sliderGreen.getValue();
		} else if(e.getSource() == sliderBlue) {
			b = sliderBlue.getValue();
		} 
		panel1.setBackground(new Color(r, g, b));
		labelRGB.setText("RGB(" + r + ", " + g + ", " + b + ")");
	}	
}

public class Exam21 {
	public static void main(String[] args) {
		Swing21 swing21 = new Swing21();
	}
}







