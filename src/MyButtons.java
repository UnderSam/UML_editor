import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButtons extends JButton{
	private boolean isSelected;
	private Mode moder;
	public MyButtons(Mode mode,String text,int x,int y,int width,int height) {
		// TODO Auto-generated constructor stub
		this.setSelected(false);
		this.setModer(mode);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				GUI.getInstance().setMode(mode.getMode());
				GUI.getInstance().setSelectButtons();
			}
		});
		this.setText(text);
		this.setBounds(x,y,width,height);
	}
	public void mousePressed(MouseEvent arg0) {
		
	}
	public boolean getSelected() { return this.isSelected;}
	public void setSelected(boolean bool) { this.isSelected = bool;}
	public Mode getModer() {
		return moder;
	}
	public void setModer(Mode mode) {
		this.moder = mode;
	}
}
