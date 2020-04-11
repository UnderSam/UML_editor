import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI {
	private JFrame frame;
	private editor myeditor;
	public GUI(editor myeditor) {
		this.setMyeditor(myeditor);
		this.frame = myeditor.getFrame();
		// TODO Auto-generated constructor stub
	}
	public void initialize() {
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Change Object name");
		mnEdit.add(mntmNewMenuItem);
		frame.getContentPane().setLayout(null);
		
		int buttonStartX = 26; 
		int buttonStartY = 50;
		int buttonStartWidth = 124; 
		int buttonStartHeight = 59;
		int buttonStep = 80;
		
		String[] buttonNameList = {"Select","Association","General","Composition","Class","UseCase"};
		ArrayList<MyButtons> buttonList = new ArrayList<MyButtons>(); 
		for(int i=0;i<buttonNameList.length;i++) {
			 buttonList.add(new MyButtons(myeditor, i, buttonNameList[i], buttonStartX, buttonStartY+i*buttonStep, buttonStartWidth, buttonStartHeight));
		}
		for(int i=0;i<buttonList.size();i++) {
			frame.getContentPane().add(buttonList.get(i));
		}
		MyPanel panel = new MyPanel(this);
		frame.getContentPane().add(panel);
		
	}
	public editor getMyeditor() {
		return myeditor;
	}
	public void setMyeditor(editor myeditor) {
		this.myeditor = myeditor;
	}
	public int getMode() {
		return this.getMyeditor().getMode();
	}


}
