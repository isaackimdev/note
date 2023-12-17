import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

class Swing04 extends JFrame {
	// 선언
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelSouth = new JPanel();
	
	JLabel labelTitle = new JLabel("",JLabel.CENTER);
	JButton jButton1 = new JButton("안  경");
	JButton jButton2 = new JButton("");
	JButton jButton3 = new JButton("인사과");
	JButton jButton4 = new JButton("총무과");
	JButton jButton5 = new JButton("서무과");
	JButton jButton6 = new JButton("경리과");
	JButton jButton7 = new JButton("핸드폰");
	JButton jButton8 = new JButton("컴퓨터");
	
	// 초기화
	public Swing04() {
		setTitle("swingswing");
		setSize(500, 300);
		setLocation(300,300);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면 구성
	private void init(){
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add("North", panelNorth);
		container.add("Center", panelCenter);
		container.add("West", panelWest);
		container.add("East", panelEast);
		container.add("South", panelSouth);
		
		// panelNorth 화면구성
		labelTitle.setBorder(new TitledBorder("Title Label"));
		labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
		labelTitle.setText("BorderLayout");

		panelNorth.setLayout(new BorderLayout());
		panelNorth.add("Center",labelTitle);
		// panelCenter 화면구성
		panelCenter.setBorder(new TitledBorder("Center"));
		panelCenter.add(jButton3);
		panelCenter.add(jButton4);
		panelCenter.add(jButton5);
		panelCenter.add(jButton6);
		// panelWest 화면구성
		jButton2.setText("Add");
		panelWest.setBorder(new TitledBorder("West"));
		panelWest.add(jButton2);
		// panelEest 화면구성
		panelEast.setBorder(new TitledBorder("East"));
		panelEast.setLayout(new GridLayout(3, 1));
		panelEast.add(jButton8);
		panelEast.add(jButton7);
		panelEast.add(jButton1);
		// panelSouth 화면구성
		panelSouth.setBorder(new TitledBorder("South"));
		
		
		
	}
	// 이벤트 설정
	private void start(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


public class Exam04 {

	public static void main(String[] args) {
		Swing04 sswing = new Swing04();
	}

}

