import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButtons extends JButton{
	private boolean isSelected;
	private int type;
	public MyButtons(editor myeditor,GUI myGUI,int Mode,String text,int x,int y,int width,int height,int type) {
		// TODO Auto-generated constructor stub
		this.setSelected(false);
		this.setType(type);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				myeditor.setMode(Mode);
				myGUI.setSelectButtons();
			}
		});
		this.setText(text);
		this.setBounds(x,y,width,height);
	}
	public boolean getSelected() { return this.isSelected;}
	public void setSelected(boolean bool) { this.isSelected = bool;}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
