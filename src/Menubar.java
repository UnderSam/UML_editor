import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menubar(Canvas panel) {
		// TODO Auto-generated constructor stub
		JMenu mnFile = new JMenu("File");
		this.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		this.add(mnEdit);
		
		JMenuItem[] ItemList = {
			new ChangeNameMenuItem("Change Object Name"),
			new GroupMenuItem("Group Item"),
			new DegroupMenuItem("Degroup Item"),
			new ClearcontentsMenuItem("ClearAll"),
		};
		for(JMenuItem item:ItemList) {
			mnEdit.add(item);
		}
	}

}
