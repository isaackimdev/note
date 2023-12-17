import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Swing25 extends JFrame {
	Container container = getContentPane();
	String[] str = {"1번", "2번", "3번", "4번"};
	// 제목으로 str배열을 가지고, 데이터가 들어갈 영역을 5행으로 표시하는 TableModel 생성
	DefaultTableModel defaultTableModel = new DefaultTableModel(str, 5);
	// TableModel을 기준으로 JTable 객체 생성
	JTable table = new JTable(defaultTableModel);
	// 스크롤 처리하기 위해서 JScrollPane에 테이블을 담는다.
	// 또한 필드의 제목 부분을 표시하는 용도로도 사용. 
	// JScrollPane에 넣지 않으면 제목이 보이지 않는다.
	JScrollPane scrollPane = new JScrollPane(table);
	
	public Swing25() {
		setTitle("swing");
		setSize(300, 300);
		setLocation(300, 300);
		init();
		start();
				
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout(5, 5));
		container.add("North", new JLabel("JTable !!!", JLabel.CENTER));
		container.add("Center", scrollPane);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(new JButton("확인"));
		panel.add(new JButton("취소"));
		container.add("South", panel);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam25 {
	public static void main(String[] args) {
		Swing25 swing25 = new Swing25();
	}
}








