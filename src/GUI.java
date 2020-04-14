import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI {
	private JFrame frame;
	private editor myeditor;
	private int objectCount;
	private int dotSize;
	public GUI(editor myeditor) {
		this.setMyeditor(myeditor);
		this.frame = myeditor.getFrame();
		this.setObjectCount(0);
		this.setDotSize(10);
		// TODO Auto-generated constructor stub
	}
	public void initialize() {
		
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Change Object name");
		mnEdit.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getActionCommand());
						String name=JOptionPane.showInputDialog(new Frame(),"Enter Name");
						if(name == null || (name != null && ("".equals(name))))   
						{
						    return;
						}
						panel.changeNameDialog(name);
					}
				}
		);
		JMenuItem mntmGroupMenuItem = new JMenuItem("Group");
		mntmGroupMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getActionCommand());
						panel.groupItem();
					}
				}
		);
		mnEdit.add(mntmGroupMenuItem );
		JMenuItem mntmDegroupMenuItem = new JMenuItem("deGroup");
		mntmDegroupMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getActionCommand());
						panel.deGroupItem();
					}
				}
		);
		mnEdit.add(mntmDegroupMenuItem);
		frame.getContentPane().setLayout(null);
		
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
	public int getObjectCount() {
		return objectCount;
	}
	public void setObjectCount(int objectCount) {
		this.objectCount = objectCount;
	}
	public int getDotSize() {
		return dotSize;
	}
	public void setDotSize(int dotSize) {
		this.dotSize = dotSize;
	}


}
