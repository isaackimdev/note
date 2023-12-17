import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PanelForm2 extends Frame implements ActionListener {
	Button button1, button2, button3;
	BorderLayout borderLayout;
	GridLayout gridLayout, gridLayout2;
	
	Panel panel , panel2;
	
	
	public PanelForm2 () {
		button1 = new Button("Test");
		button2 = new Button("Test1");
		button3 = new Button("Test2");
		borderLayout = new BorderLayout();
		gridLayout = new GridLayout(1,2);	// 1행 2열
		gridLayout2 = new GridLayout(2, 1);
		panel = new Panel();
		panel2= new Panel();
	
		setTitle("Panel");
		setSize(300, 200);
		setLocation(300,300);
		
		init();
		start();
		
		setVisible(true);
	}
	


	// 화면 구성
	private void init() {
		// 프레임 설정
		setLayout(borderLayout); 	// frame (panel) 내의 레이아웃 설정
		panel.setLayout(gridLayout);	// 
		panel2.setLayout(gridLayout2);	// 
		
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.PINK);
		button3.setBackground(Color.GREEN);
		
		panel.add(button1);
		panel.add(panel2);
		panel2.add(button2);
		panel2.add(button3);
		/* BorderLayout 배치 */
		add("South", panel);
		
	}
	// 이벤트 설정
	private void start() {
		// 확인 버튼을 눌렀을 떄의 처리
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
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog dialog = new Dialog(this);
		dialog.setLocation(400,400);
		
		if(e.getSource() == button1 ) {
			dialog.setTitle("Test");
			dialog.setVisible(true);
		} else if (e.getSource() == button2) {
			dialog.setTitle("Test1");
			dialog.setVisible(true);	
		} else if (e.getSource() == button3) {
			dialog.setTitle("Test2");
			dialog.setVisible(true);	
		}
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
				super.windowClosing(e);
			}
		});
	}
}



public class Practice1 {

	public static void main(String[] args) {
		PanelForm2 panelForm2 = new PanelForm2();
	}

}
