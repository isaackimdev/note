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

class PracticeForm extends Frame implements ActionListener{
	Button button1, button2, button3;
	BorderLayout borderLayout;
	GridLayout gridLayout1, gridLayout2;
	Panel panel1, panel2;
	
	public PracticeForm() {
		button1=new Button("test");
		button2=new Button("test1");
		button3=new Button("test2");
		borderLayout = new BorderLayout();
		gridLayout1 = new GridLayout(1, 2); // 1행 2열
		gridLayout2 = new GridLayout(2, 1); // 2행 1열
		panel1 = new Panel();
		panel2= new Panel();
		
		setTitle("panel 연습");
		setSize(300, 300);
		setLocation(300 , 300);
		
		init();
		start();
		
		setVisible(true);
	}
	// 화면 꾸미기 ( 작은 것에서  >> 큰 것으로... )
	private void init() {
		setLayout(borderLayout);		// frame layout 설정
		panel1.setLayout(gridLayout1);	// panel1 Layout 설정, 1행 2열
		panel2.setLayout(gridLayout2);	// panel2 Layout 설정, 2행 1열
		// Button 꾸미기
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.MAGENTA);
		button3.setBackground(Color.GREEN);
		// panel2 꾸미기
		panel2.add(button2);
		panel2.add(button3);
		// panel1 꾸미기
		panel1.add(button1);
		panel1.add(panel2);
		// Frame 꾸미기
		add("South", panel1);
		
		
	}
	// 이벤트 설정
	private void start() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
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
		dialog.setLocation(400, 400);
		if(e.getSource() == button1) {
			dialog.setTitle("test");
			dialog.setVisible(true);
		} else if (e.getSource() == button2) {
			dialog.setTitle("test1");
			dialog.setVisible(true);
		} else if (e.getSource() == button3) {
			dialog.setTitle("test2");
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
public class Practice1_1 {

	public static void main(String[] args) {
		PracticeForm practiceForm = new PracticeForm();
	}

}
