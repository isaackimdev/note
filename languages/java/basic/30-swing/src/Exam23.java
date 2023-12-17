import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

class Swing23 extends JFrame {
	Container container = getContentPane();
	JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false,
			new JButton("위 버튼"), new JButton("아래 버튼"));
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
			new JButton("좌측버튼"), splitPane1); 
	
	JLabel label = new JLabel("Test");

	JButton button1 = new JButton("좌측 버튼");

	public Swing23() {
		setTitle("swing");
		setSize(300, 200);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		// 아래의 컴포넌트를 다른 컴포넌트로 변경
		splitPane1.setTopComponent(new JButton("위1 버튼"));
		splitPane1.setBottomComponent(new JButton("아래1 버튼"));
		splitPane2.setLeftComponent(new JButton("좌측1 버튼"));
		// 분할자의 위치를 조절할 때 연속적으로 각 패널을 다시 그릴지 설정
		splitPane1.setContinuousLayout(true);
		// 한번의 클릭으로 확대/축소가 가능하도록 설정
		splitPane1.setOneTouchExpandable(true);
		// 크기가 변경될 때의 가중치, 어느 정도의 이동거리를 만들지 결정
		splitPane1.setResizeWeight(0.5);
		

		container.add("Center", splitPane2);
		
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam23 {
	public static void main(String[] args) {
		Swing23 swing23 = new Swing23();
	}
}
