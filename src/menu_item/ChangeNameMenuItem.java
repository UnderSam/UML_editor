package menu_item;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gui.GUI;
import shape.Shape;

public class ChangeNameMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChangeNameMenuItem(String name) {
		// TODO Auto-generated constructor stub
		this.setText(name);
		this.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String name=JOptionPane.showInputDialog(new Frame(),"Enter Name");
						if(name == null || (name != null && ("".equals(name))))
						{
						    return;
						}
						for(Shape item:GUI.getInstance().getCanvas().getShapeArrayList()) {
							if(item.getObjectid()==0 && item.isSelected()) {
								item.setName(name);
							}
						}
						GUI.getInstance().getCanvas().repaint();
					}
				});
	}

}
