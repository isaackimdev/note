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

class Swing03 extends JFrame{
	// 선언
		JButton button1, button2, button3, button4;
		JButton button5, button6, button7, button8;
		GridLayout gridLayout;
		// 초기화
		public Swing03() {
			button1 = new JButton("Empty");
			button2 = new JButton("Line");
			button3 = new JButton("Etched");
			button4 = new JButton("Bevel");
			button5 = new JButton("SoftBevel");
			button6 = new JButton("Matte");
			button7 = new JButton("Titled");
			button8 = new JButton("Compound");
			gridLayout = new GridLayout(4, 2, 5, 5);
			
			// JFrame 설정
			setTitle("swing");
			setSize(300, 300);
			setLocation(300, 300);
			
			init();
			start();
			
			setVisible(true);
		}
		// 화면구성
		private void init() {
			// getContentPane() : JFrame에서 작업 영역만 따로 떼어낸다.
			Container container = getContentPane();
			container.setLayout(gridLayout);
			
			// EmptyBorder : Label처럼 평면 형태를 보여주는 보더
			EmptyBorder eb = new EmptyBorder(0, 0, 0, 0);
			button1.setBorder(eb);
			container.add(button1);
			
			// LineBorder : 컴포넌트 주위에 라인을 표현하는 보더로 라인의 두께를 설정할 수 있다.
			LineBorder lb = new LineBorder(Color.ORANGE, 3);
			button2.setBorder(lb);
			container.add(button2);
			
			// EtchedBorder : 컴포넌트 주위에 홈이 파여 있는 모양을 표현하는 보더
			EtchedBorder etb = new EtchedBorder();
			button3.setBorder(etb);
			container.add(button3);
			
			// BevelBorder : 컴포넌트가 올라오거나 내려간 모양을 표현할 때 사용하는 보더
			BevelBorder bb = new BevelBorder(BevelBorder.RAISED);
			button4.setBorder(bb);
			container.add(button4);
			
			// SoftBevelBorder
			SoftBevelBorder sbb = new SoftBevelBorder(SoftBevelBorder.LOWERED);
			button5.setBorder(sbb);
			container.add(button5);
			
			// MatteBorder : 테두리의 두께를 설정하여 라인이나 이미지를 넣을 수 있는 보더
			MatteBorder mb = new MatteBorder(5,10,15,20,Color.BLUE);
			button6.setBorder(mb);
			container.add(button6);
			
			// TitledBorder : 컴포넌트 주위로 제목을 주는 보더. 라인과 같은 효과도 줄 수 있다.
			TitledBorder tb = new TitledBorder("제목");
			button7.setBorder(tb);
			container.add(button7);
			
			// CompoundBorder : 두 가지 이상의 보더 효과를 동시에 줄 수 있는 보더
			SoftBevelBorder sbb1 = new SoftBevelBorder(SoftBevelBorder.RAISED);
			TitledBorder tb1 = new TitledBorder("제목");
			CompoundBorder cb = new CompoundBorder(sbb1,tb1);
			button8.setBorder(cb);
			container.add(button8);		
		}
		// 이벤트 설정
		private void start() {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
}
public class Exam03 {
	public static void main(String[] args) {

		Swing03 s3 = new Swing03();	


	}


}
