import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.text.DateFormatSymbols;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

class Swing20 extends JFrame {
	// 선언
	Container container ;
	JRootPane rootPane;
	JPanel panel = new JPanel(new GridLayout(3,1));
	JSpinner spinner1 = new JSpinner();
	JSpinner spinner2 = new JSpinner();
	JSpinner spinner3 = new JSpinner();
	JTextField textField = new JTextField();
	
	DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
	String[] str = dateFormatSymbols.getMonths();

	SpinnerListModel spinnerListModel = new SpinnerListModel(str);
	// 현재 시스템의 날짜 값을 그대로 가져온다.
	SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
	// 0~100 사이의 숫자값으로 50을 기본 값으로 나타내고 2씩 증가나 감소 시킨다.
	SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(50, 0, 100, 2);
	
	// 초기화 : 생성자
	public Swing20() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		rootPane = getRootPane();
		container = rootPane.getContentPane();
		container.setLayout(new BorderLayout());
		
		spinner1.setModel(spinnerListModel);
		spinner2.setModel(spinnerDateModel);
		spinner3.setModel(spinnerNumberModel);
		panel.add(spinner1);
		panel.add(spinner2);
		panel.add(spinner3);
		
		container.add("North", panel);
		
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

public class Exam20 {
	public static void main(String[] args) {
		Swing20 swing20 = new Swing20();
	}
}
