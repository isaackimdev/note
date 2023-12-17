import java.awt.Container;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Swing01 extends JFrame {
	// 선언
	ImageIcon imageIcon = new ImageIcon("img/Bird.gif");
	Container container = getContentPane();
	
	
	// 초기화 : 생성자 
	public Swing01() {
		
		setIconImage(imageIcon.getImage());
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	// 이벤트 처리
	
}
public class Exam01 {
	public static void main(String[] args) {
		Swing01 swing01 = new Swing01();
	}
}

//import java.awt.Container;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//
//class Swing01 extends JFrame{
//	Container container;	// 컨텐치어 선언, : 작업 영역을 위한 기본 Panel을 담을 객체
//	ImageIcon imageIcon;	// 타이틀 바의 이미지를 가지는 객체
//	// 초기화
//	public Swing01() {
//		//JFrame 설정
//		imageIcon = new ImageIcon("img/Bird.gif");	// 특정 이미지 객체 생성
//		setTitle("제목");								// 타이틀
//		setIconImage(imageIcon.getImage());			// 타이틀 바에 이미지 넣기
//		setSize(300, 300);
//		setLocation(300, 300);
//		
//		init();
//		start();
//		
//		setVisible(true);
//	}
//	// 화면 구성
//	private void init() {
//		// getContentPane() : JFrame 에서 작업 영역만 따로 떼어낸다.
//		container = getContentPane();	// 다중 Panel에서의 기본 작업 영역 획득
//		// 폼 구성 영역
//		
//	}
//	// 이벤트 설정
//	private void start() {
//		// Frame의 X버튼을 눌렀을 때의 Event (WindowEvent Closing)
//		// 윈도우 창의 X 버튼을 눌렀을 떄, 윈도우 클로우징 이벤트 설정
//		// 프레임의 X 버튼을 누루면, AWT에서는 Window Event를 발생시켜야 했지만,
//		// swing에서 JFrame 에는 이미 메소드로 만들어 두었기 때문에 기본 작업을 할 수 있다.
//		setDefaultCloseOperation(EXIT_ON_CLOSE);	// 종료 명령어
////		addWindowListener(new WindowAdapter() {
////			@Override
////			public void windowClosing(WindowEvent e) {
////				System.exit(0);
////				super.windowClosing(e);
////			}
////		});
//	}
//	// 이벤트 처리
//	
//}
//
//public class Exam01 {
//	public static void main(String[] args) {
//		// JFrame 을 이용하여 화면 띄우기
//		
//		Swing01 swing01 = new Swing01();
//	}
//}
