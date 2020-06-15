package menu_item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.GUI;
import shape.GroupObject;
import shape.Shape;

public class GroupMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GroupMenuItem(String name) {
		// TODO Auto-generated constructor stub
		this.setText(name);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0.getActionCommand());
				if(GUI.getInstance().getCanvas().countSelect()<2) { // check must two obj be selected
					return;
				}
				GroupObject newGroup = new GroupObject(GUI.getInstance().getCanvas().getShapeArrayList().size()+1);
				int maxdepth = -999;
				for(Shape item:GUI.getInstance().getCanvas().getShapeArrayList()) {
					if(item.isSelected()) {
						System.out.println(item+" "+item.getDepth());
						maxdepth = item.getDepth()>maxdepth?item.getDepth():maxdepth;
						newGroup.addchild(item);
					}
				}
				newGroup.setDepth(maxdepth);
				for(Shape item:newGroup.getGroupArrayList()) {
					GUI.getInstance().getCanvas().getShapeArrayList().remove(item);
				}
				GUI.getInstance().getCanvas().getShapeArrayList().add(newGroup);
				GUI.getInstance().getCanvas().getShapeArrayList().sort(GUI.getInstance().getCanvas().getC());
			}
		});
	}

}
