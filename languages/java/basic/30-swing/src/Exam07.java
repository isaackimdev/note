import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

class Swing07 extends JFrame {
	// 선언
	JMenuBar jMenuBar = new JMenuBar();		// 메뉴 타이틀을 나타냄
	
	JMenu menuFile = new JMenu("파일");
	JMenuItem fileNew = new JMenuItem("새파일");
	ImageIcon imageIcon1 = new ImageIcon("img/cat.gif");
	JMenuItem fileOpen = new JMenuItem(imageIcon1);
	ImageIcon imageIcon2 = new ImageIcon("img/dog.gif");
	JMenuItem fileExit = new JMenuItem("종료" , imageIcon2);
	
	JMenu menuEdit = new JMenu("수정");
	
	JMenu menuEditSize = new JMenu("크기");
	JRadioButtonMenuItem ediSize10 = new JRadioButtonMenuItem("10");
	JRadioButtonMenuItem ediSize20 = new JRadioButtonMenuItem("20");
	JRadioButtonMenuItem ediSize30 = new JRadioButtonMenuItem("30");
	ButtonGroup buttonGroup = new ButtonGroup();
	
	JMenu menuEditColor = new JMenu("색상");
	JCheckBoxMenuItem editRed = new JCheckBoxMenuItem("RED");
	JCheckBoxMenuItem editGreen = new JCheckBoxMenuItem("Green");
	JCheckBoxMenuItem editBlue = new JCheckBoxMenuItem("Blue");
	
	JMenu menuHelp = new JMenu("도움말");
	//초기화
	public Swing07() {
		setTitle("Swing");
		setSize(300,300);
		setLocation(300,300);
		
		init();
		start();
		
		setVisible(true);
		
	}
	//화면 설정
	private void init() {
		// 프레임에 메뉴바 추가
		setJMenuBar(jMenuBar);
		// goekd apsbrk duffuTdmf EO, wkehddmfh tjsxorehlsms dnlclfh wlwjd
		fileExit.setArmed(true);
		
		menuFile.add(fileNew);
		menuFile.addSeparator();
		menuFile.add(fileOpen);
		menuFile.addSeparator();
		menuFile.add(fileExit);
		jMenuBar.add(menuFile);
		
		menuEdit.setBorder(new LineBorder(Color.RED, 3));
		menuEditSize.setBorder(new BevelBorder(BevelBorder.RAISED));
		menuEditColor.setBorder(new BevelBorder(BevelBorder.RAISED));
		buttonGroup.add(ediSize10);
		buttonGroup.add(ediSize20);
		buttonGroup.add(ediSize30);
		menuEditSize.add(ediSize10);
		menuEditSize.add(ediSize20);
		menuEditSize.add(ediSize30);
		menuEdit.add(menuEditSize);
		menuEdit.addSeparator();
		menuEditColor.add(editRed);
		menuEditColor.add(editGreen);
		menuEditColor.add(editBlue);
		menuEdit.add(menuEditColor);
		jMenuBar.add(menuEdit);
		
		jMenuBar.add(menuHelp);
		
		Container container = getContentPane();		// 화면에다가 넣는 것 , panel 과  Layout
		container.setLayout(new BorderLayout());
	}
	//
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

public class Exam07 {

	public static void main(String[] args) {
		Swing07 swing07 = new Swing07(); 
	}

}
