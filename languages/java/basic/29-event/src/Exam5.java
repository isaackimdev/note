import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// 리스너는 인터페이스 어탭트는 클래스
class BaseForm extends Frame implements ActionListener{
	Button button1, button2, button3;
	FlowLayout flowLayout;
	GridLayout gridLayout;
	BorderLayout borderLayout;
	// Frame 초기화
	public BaseForm() {	// Layout과 panel을 알아야 함.
		button1 = new Button("버튼1");
		button2 = new Button("버튼2");
		button3 = new Button("버튼3");
		// FlowLayout : 컴포넌트를 왼쪽에서 오른쪽으로 배치
		flowLayout = new FlowLayout();
		// GridLayout(행의 수, 열의 수, 가로 여백, 세로 여백) : 컴포넌트를 행열로 배치
		gridLayout = new GridLayout(2, 2, 5, 5);
		// BorderLayout : 컴포넌트를 동서남북으로 배치
		borderLayout = new BorderLayout();
		// Frame 설정
		setTitle("layout manager");
		setSize(300,200);
		setLocation(300,300);	// 윈도우 화면 기준으로  300,300( 모니터 기준으로 출력 함)
		
		init2();
		start();
		
		setVisible(true);
	}
	
	// 화면 구성
	// BorderLayout
	private void init2() {
		setLayout(borderLayout);	// frame 한테 있는 클래스  // 컴퍼넌트를 왼쪽에서 오른쪽으로 배치  // 현재 레이아웃 세팅을 했음
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);
		button3.setBackground(Color.CYAN);
		/* BorderLayout 배치 */
		add("North", button1);	// default 값이 senter
		add(button2);
		add("South", button3);
	}
	// GridLayout
	private void init1() {
		setLayout(gridLayout);	// frame 한테 있는 클래스  // 컴퍼넌트를 왼쪽에서 오른쪽으로 배치  // 현재 레이아웃 세팅을 했음
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);
		button3.setBackground(Color.CYAN);
		/* FremeLayout, GridLayout 배치 */
		add(button1);
		add(button2);
		add(button3);
	}
	// flowLayout
	private void init() {
		setLayout(flowLayout);	// frame 한테 있는 클래스  // 컴퍼넌트를 왼쪽에서 오른쪽으로 배치  // 현재 레이아웃 세팅을 했음
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);
		button3.setBackground(Color.CYAN);
		/* FremeLayout, GridLayout 배치 */
		add(button1);
		add(button2);
		add(button3);
	}
	// 이벤트 설정
	private void start() {
		// 확인 버튼을 눌렀을 때의 처리
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		// 프레임 창의 x버튼의 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
			
		});
	}
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog dialog = new Dialog(this);
		dialog.setLocation(400, 400);
	
		if(e.getSource() == button1) {				// 어떤 클래스가 눌렸는지를 알 수 있음
			dialog.setTitle("버튼1");
			dialog.setVisible(true);
		} else if (e.getSource() == button2) {
			dialog.setTitle("버튼2");
			dialog.setVisible(true);
		} else if (e.getSource() == button3) {
			dialog.setTitle("버튼3");
			dialog.setVisible(true);
		}
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();	// Dialog 창 닫기
				super.windowClosing(e);
			}
		});
	}
	
}
public class Exam5 {

	public static void main(String[] args) {
		BaseForm baseform = new BaseForm();

	}

}
