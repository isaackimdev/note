import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
class Swing3 extends JFrame{
	// 선언
	JButton button1, button2, button3, button4;
	JButton button5, button6, button7, button8;
	GridLayout gridLayout;
	// 초기화
	public Swing3() {
		button1 = new JButton("Empty");
		button2 = new JButton("Line");
		button3 = new JButton("Etched");
		button4 = new JButton("Bevel");
		button5 = new JButton("SoftBevel");
		button6 = new JButton("Matte");
		button7 = new JButton("Titled");
		button8 = new JButton("Compound");
		gridLayout = new GridLayout(4, 2 ,5,5); 	// 4행 2열
		
		// JFrame 설정
		setTitle("swing");
		setSize(300 ,300);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면 설정
	private void init() {
		// getContentPane() : JFrame 에서 작업 영역만 따로 떼어낸다.
		Container container = getContentPane();
		container.setLayout(gridLayout);
		// EmptyBorder : Label 처럼 평면 형태를 보여주는 보더
		EmptyBorder emptyBorder = new EmptyBorder(5, 3, 5, 3);
		button1.setBorder(emptyBorder);
		container.add(button1);
		// LineBorder : 컴포넌트 주위에 라인을 표현하는 보더로 라인의 두께를 설정할 수 있다.
		LineBorder lineBorder = new LineBorder(Color.RED, 3);
		button2.setBorder(lineBorder);
		container.add(button2);
		// EtchedBorder : 컴포넌트 주위에 홈이 파여 있는 모양을 표현하는 보더
		EtchedBorder etchedBorder = new EtchedBorder();
		button3.setBorder(etchedBorder);
		container.add(button3);
		// BevelBorder : 컴포넌트가 올라오거나 내려간 모양을 표현할 떄 사용하는 보더
		BevelBorder bevelBorder = new BevelBorder(BevelBorder.RAISED);
		button4.setBorder(bevelBorder);
		container.add(button4);
		// SoftBevelBorder
		SoftBevelBorder softBevelBorder = new SoftBevelBorder(BevelBorder.LOWERED);
		button5.setBorder(softBevelBorder);
		container.add(button5);
		// MatteBorder : 테두리의 두께를 설정하여 라인이나 이미지를 넣을 수 있는 보더
		MatteBorder matteBorder = new MatteBorder(5, 10, 15 ,20, Color.BLUE);	//top, left, bottom, right
		button6.setBorder(matteBorder);
		container.add(button6);
		// TitledBorder : 컴포넌트 주위로 제목을 주는 보더, 라인과 같은 효과도 줄 수 있다.
		TitledBorder titledBorder = new TitledBorder("유후");
		button7.setBorder(titledBorder);
		container.add(button7);
		// CompoundBorder : 두 가지 이상의 보더 효과를 동시에 줄수 있는 보더
		SoftBevelBorder softBevelBorder2 = new SoftBevelBorder(SoftBevelBorder.RAISED);
		TitledBorder titledBorder2 = new TitledBorder("제목");
		CompoundBorder compoundBorder = new CompoundBorder(softBevelBorder2, titledBorder2);
		button8.setBorder(compoundBorder);
		container.add(button8);
	}
	// 이벤트 설정
	private void start() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);		// X 눌렀을때 종료	
	}
	// 이벤트 처리
}

public class Exam3 {
	// Border Class >> Container를 이쁘게 꾸며주는 클래스
	public static void main(String[] args) {
		Swing3 swing3 = new Swing3();
	}

}



