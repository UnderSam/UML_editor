import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButtons extends JButton{
	public MyButtons(editor myeditor,int Mode,String text,int x,int y,int width,int height) {
		// TODO Auto-generated constructor stub
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("setMode");
				myeditor.setMode(Mode);
			}
		});
		this.setText(text);
		this.setBounds(x,y,width,height);
	}
}
