//import java.awt.Container;
//import java.awt.GridLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JRadioButton;
//
//class Swing06 extends JFrame {
//	// 선언
//	JRadioButton jRadioButtonGirl, jRadioButtonMan, jRadioButtonTeen, jRadioButtonAdult;
//	
//	// 초기화
//	public Swing06() {
//		jRadioButtonGirl.setText("여자");
//		jRadioButtonMan.setText("남자");
//		jRadioButtonTeen.setText("청소년");
//		jRadioButtonAdult.setText("성인");
//		
//		setTitle("swinggg");
//		setSize(200,200);
//		setLocation(300,300);
//		
//		init();
//		start();
//		
//		setVisible(true);
//	}
//	// 화면 설정
//	private void init(){
//		// JFrame 설정
//		Container container = getContentPane();
//		container.setLayout(new GridLayout(2, 2));
//		container.add(jRadioButtonGirl);
//		container.add(jRadioButtonMan);
//		container.add(jRadioButtonTeen);
//		container.add(jRadioButtonAdult);
//		
//		
//	}
//	// 이벤트 설정
//	private void start(){
//		
//	}
//	// 이벤트 처리
//}
//
//public class Exam06 {
//	public static void main(String[] args) {
//		Swing06 swing06 = new Swing06();
//	}
//}
///////////////// ============== ///// 아래는 선생님이 푸신거 
//
//import java.awt.Container;
//import java.awt.GridLayout;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JFrame;
//import javax.swing.JRadioButton;
//
//class Swing06 extends JFrame {
//	private Container container = getContentPane();	
//	private GridLayout gridLayout = new GridLayout(2, 2, 5, 5);
//
//	private JRadioButton radioButton1 = new JRadioButton("여자", true);
//	private JRadioButton radioButton2 = new JRadioButton("남자");
//	private JRadioButton radioButton3 = new JRadioButton("청소년");
//	private JRadioButton radioButton4 = new JRadioButton("성인", true);
//
//	private ButtonGroup buttonGroup1 = new ButtonGroup();
//	private ButtonGroup buttonGroup2 = new ButtonGroup();
//	
//	public Swing06() {
//		// JFrame 설정
//		this.setTitle("swing");			// 타이틀
//		this.setSize(200, 100);		
//		this.setLocation(300, 300);
//		
//		init();		// 화면 구성
//		start();		// 이벤트 설정
//		
//		this.setVisible(true);
//	}
//
//	public void init() {
//		container.setLayout(gridLayout);
//		
//		buttonGroup1.add(radioButton1);
//		buttonGroup1.add(radioButton2);
//		buttonGroup2.add(radioButton3);
//		buttonGroup2.add(radioButton4);
//		
//		container.add(radioButton1);
//		container.add(radioButton2);
//		container.add(radioButton3);
//		container.add(radioButton4);
//	}
//
//	public void start() {
//		setDefaultCloseOperation(EXIT_ON_CLOSE);		
//	}
//}
//
//public class Exam06 {
//
//	public static void main(String[] args) {
//		Swing06 swing = new Swing06();
//	}
//}
//
