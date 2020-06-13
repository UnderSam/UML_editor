import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ClearcontentsMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClearcontentsMenuItem(String name) {
		// TODO Auto-generated constructor stub
		this.setText(name);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand());
				GUI.getInstance().getCanvas().getShapeArrayList().clear();
				GUI.getInstance().getCanvas().getGroupShapeList().clear();
				GUI.getInstance().getCanvas().diselectShapeList();
				GUI.getInstance().getCanvas().repaint();
			}
		});
	}

}
