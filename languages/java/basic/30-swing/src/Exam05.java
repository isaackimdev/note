import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

class Swing05 extends JFrame {
	// 선언
	Container container = getContentPane();
	GridLayout gridLayout = new GridLayout(2, 2, 5, 5);
	JToggleButton toggleButton1 = new JToggleButton("1", true);			// toggle 버튼
	JToggleButton toggleButton2 = new JToggleButton("2", false);		// toggle 버튼
	JToggleButton toggleButton3 = new JToggleButton("3", false);		// toggle 버튼
	JToggleButton toggleButton4 = new JToggleButton("4", false);		// toggle 버튼	on/off 툭툭 튀어나오는 것.
	ButtonGroup buttonGroup = new ButtonGroup();
	
	// 초기화
	public Swing05() {
		setTitle("swing5");
		setSize(300,300);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init(){
		container.setLayout(gridLayout);
		// buttonGroup 라는 그룹에 버튼을 추가, 묶어버림.
		buttonGroup.add(toggleButton1);
		buttonGroup.add(toggleButton2);
		buttonGroup.add(toggleButton3);
		buttonGroup.add(toggleButton4);

		container.add(toggleButton1);
		container.add(toggleButton2);
		container.add(toggleButton3);
		container.add(toggleButton4);
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam05 {
	public static void main(String[] args) {
		Swing05 swing05 = new Swing05();
	}
}
