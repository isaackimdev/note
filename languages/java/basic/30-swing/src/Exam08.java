import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

class Swing08 extends JFrame {
	// 선언
	Container container = getContentPane();
	FlowLayout flowLayout = new FlowLayout();
	JButton[] jButtons = new JButton[6];
	Box box1, box2, box3;
	// 초기화
	public Swing08() {
		setTitle("swing");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면구성
	private void init() {
		// 컨테이너 레이아웃 먼저 설정
		container.setLayout(flowLayout);
		
		for(int i = 0; i<jButtons.length; i++) {
			jButtons[i] = new JButton(String.valueOf(i+1));	// 숫자로 주면 오류가 생겨서, 정수를 문자열로 바껴써 줌.. 그럼 버튼에 1/2/3//4/5/6이 들어가게 됨
		}
		// 새로축으로 컴포넌트를 추가하는 Box 객체를 생성한다.
		box1 = Box.createVerticalBox();	// 수직
		box1.add(Box.createVerticalStrut(10));	// 10픽셀의 사이에 간격을 추가한다.
		for(int i = 0 ; i<3; i++) {
			box1.add(jButtons[i]);		// 세로박스에다가 붂어 놓음
			box1.add(Box.createVerticalStrut(10));
		}
		// 가로축으로 컴포넌트를 추가하는 Box 객체를 생성한다.
		box2 = Box.createHorizontalBox();
		box2.add(Box.createVerticalStrut(170));
		for(int i=3; i<6; i++) {
			box2.add(jButtons[i]);
			box2.add(Box.createHorizontalStrut(10));	// 10픽셀의 사이 간격을 추가한다.
		}
		
		box3 = Box.createHorizontalBox();
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(30));
		box3.add(box2);
		
		container.add(box3);	// container 에다가 집어넣음
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// 이벤트 처리	
}

public class Exam08 {
	public static void main(String[] args) {
		Swing08 swing08 = new Swing08();
	}
}
