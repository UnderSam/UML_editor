import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI {
	private JFrame frame;
	private editor myeditor;
	private int objectCount;
	private ArrayList<MyButtons> buttonList;
	public GUI(editor myeditor) {
		this.setMyeditor(myeditor);
		this.frame = myeditor.getFrame();
		this.setObjectCount(0);
		// TODO Auto-generated constructor stub
	}
	public void initialize() {
		
		int buttonStartX = 26; 
		int buttonStartY = 50;
		int buttonStartWidth = 124; 
		int buttonStartHeight = 59;
		int buttonStep = 80;
		Canvas canvas = new Canvas(this);
		frame.getContentPane().add(canvas);
		Menubar menubar = new Menubar(canvas);
		frame.setJMenuBar(menubar);
		
		String[] buttonNameList = {"Select","Association","General","Composition","Class","UseCase"};
		Mode[] modelist = {
				new Selectmode(0, canvas),
				new Assoclinemode(1, canvas),
				new Composlinemode(2, canvas),
				new Generalinemode(3, canvas),
				new Classobjmode(4, canvas),
				new Usecasobjmode(5, canvas)
		};
		buttonList = new ArrayList<MyButtons>(); 
		for(int i=0;i<buttonNameList.length;i++) {
			 buttonList.add(new MyButtons(this, modelist[i], buttonNameList[i], buttonStartX, buttonStartY+i*buttonStep, buttonStartWidth, buttonStartHeight));
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
		this.getMyeditor().setMode(mode);
	}
	
}
