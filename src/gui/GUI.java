package gui;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import menu_item.Menubar;
import mode.Assoclinemode;
import mode.Classobjmode;
import mode.Composlinemode;
import mode.Generalinemode;
import mode.Mode;
import mode.Selectmode;
import mode.Usecasobjmode;

public class GUI {
	private int mode;
	private ArrayList<MyButtons> buttonList;
	private static GUI instance = new GUI();
	private Canvas canvas;
	private GUI() {}
	public static GUI getInstance() {
		return instance;
	}
	public void initialize() {
		
		int buttonStartX = 26; 
		int buttonStartY = 50; 
		int buttonStartWidth = 124; 
		int buttonStartHeight = 59;
		int buttonStep = 80;
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 984, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Canvas canvas = new Canvas();
		this.setCanvas(canvas);
		frame.getContentPane().add(canvas);
		Menubar menubar = new Menubar(canvas);
		frame.setJMenuBar(menubar);
		
		String[] buttonNameList = {"Select","Association","General","Composition","Class","UseCase"};
		Mode[] modelist = {
				new Selectmode(0),
				new Assoclinemode(1),
				new Generalinemode(2),
				new Composlinemode(3),
				new Classobjmode(4),
				new Usecasobjmode(5)
		};
		buttonList = new ArrayList<MyButtons>(); 
		for(int i=0;i<buttonNameList.length;i++) {
			 buttonList.add(new MyButtons(modelist[i], buttonNameList[i], buttonStartX, buttonStartY+i*buttonStep, buttonStartWidth, buttonStartHeight));
		}
		for(int i=0;i<buttonList.size();i++) {
			frame.getContentPane().add(buttonList.get(i));
		}

		frame.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	public int getMode() {
		return this.mode;
	}
	public void setSelectButtons() {
		for(MyButtons element : this.getButtonList()) {
			if(element.getModer().getMode()!=this.getMode()) {
				element.setBackground(null);
				element.setSelected(false);
			}else {
				element.setBackground(Color.lightGray);
				element.setSelected(true);
			}
		}
	}
	public ArrayList<MyButtons> getButtonList() {
		return buttonList;
	}
	public void setButtonList(ArrayList<MyButtons> buttonList) {
		this.buttonList = buttonList;
	}
	public void setMode(int mode) {
		// TODO Auto-generated method stub
		this.mode = mode;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
}
