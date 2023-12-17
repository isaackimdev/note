import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

class Swing4 extends JFrame {
	// 선언
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelSouth = new JPanel();
	
	JLabel labelTitle = new JLabel("BorderLayout",JLabel.CENTER);
	JButton jButton1 = new JButton("Add");
	JButton jButton2 = new JButton("인사과");
	JButton jButton3 = new JButton("총무과");
	JButton jButton4 = new JButton("사무과");
	JButton jButton5 = new JButton("경리과");
	JButton jButton6 = new JButton("컴퓨터");
	JButton jButton7 = new JButton("핸드폰");
	JButton jButton8 = new JButton("안  경");
	
	// 초기화 : 생성자
	public Swing4() {
		// JFrame 설정
		setTitle("Swing04");
		setSize(500,300);
		setLocation(300,300);
		
		init();
		start();
		
		setResizable(false); // 화면 고정
		setVisible(true);
	}
	// 화면설정
	private void init() {
		// JFrame 레이아웃 설정
		setLayout(new BorderLayout());
		// getContentPane() : JFrame에서 작업 영역만 따로 떼어낸다.
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		// 북 패널에 입력하기
		TitledBorder titledBorderN = new TitledBorder("North"); 
		panelNorth.setBorder(titledBorderN);
		panelNorth.setLayout(new GridLayout(1,1));
		panelNorth.add(labelTitle);
		
		// 서 패널에 입력
		TitledBorder titledBorderW = new TitledBorder("West"); 
		panelWest.setBorder(titledBorderW);
//		panelWest.setLayout(new GridLayout(6,1));
		// default Layout은 FlowLayout
		panelWest.add(jButton1);
		// 센터 패널에 입력
		TitledBorder titledBorderC = new TitledBorder("Center"); 
		panelCenter.setBorder(titledBorderC);
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(jButton2);
		panelCenter.add(jButton3);
		panelCenter.add(jButton4);
		panelCenter.add(jButton5);
		// 동 패널에 입력
		TitledBorder titledBorderE = new TitledBorder("East"); 
		panelEast.setBorder(titledBorderE);
		panelEast.setLayout(new GridLayout(3,1));
		panelEast.add(jButton6);
		panelEast.add(jButton7);
		panelEast.add(jButton8);
		// 남 패널에 입력
		TitledBorder titledBorder = new TitledBorder("South"); 
		panelSouth.setLayout(new GridLayout(1,1));
		panelSouth.setBorder(titledBorder);
		

		// 프레임에 구역 및 배치해주기
		add("North", panelNorth);
		add("Center", panelCenter);
		add("West", panelWest);
		add("East", panelEast);
		add("South", panelSouth);
		
	}
	// 이벤트 설정
	private void start() {}
	// 이벤트 처리
}

public class Exam4 {

	public static void main(String[] args) {
		Swing4 swing4 = new Swing4();
	}

}
