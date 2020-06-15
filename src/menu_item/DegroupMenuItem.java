package menu_item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.GUI;
import shape.Shape;

public class DegroupMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DegroupMenuItem(String name) {
		// TODO Auto-generated constructor stub
		this.setText(name);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand());
				int cursor_x = GUI.getInstance().getCanvas().getClick_x();
				int cursor_y = GUI.getInstance().getCanvas().getClick_y();
				for(Shape item:GUI.getInstance().getCanvas().getShapeArrayList()) {
					if(item.contain(cursor_x, cursor_y)) {
						for(Shape newItem:item.deGroup()) {
							GUI.getInstance().getCanvas().getShapeArrayList().add(newItem);
						}
						if(item.deGroup().size()>0) {
							GUI.getInstance().getCanvas().getShapeArrayList().remove(item);
						}					
						break;
					}
				}
				GUI.getInstance().getCanvas().getShapeArrayList().sort(GUI.getInstance().getCanvas().getC());
			}
		});
	}

}
