import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menubar extends JMenuBar{

	public Menubar(MyPanel panel) {
		// TODO Auto-generated constructor stub
		JMenu mnFile = new JMenu("File");
		this.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		this.add(mnEdit);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Change Object name");
		mnEdit.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String name=JOptionPane.showInputDialog(new Frame(),"Enter Name");
						if(name == null || (name != null && ("".equals(name))))   
						{
						    return;
						}
						panel.changeNameDialog(name);
					}
				}
		);
		JMenuItem mntmGroupMenuItem = new JMenuItem("Group");
		mntmGroupMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getActionCommand());
						panel.groupItem();
					}
				}
		);
		mnEdit.add(mntmGroupMenuItem );
		JMenuItem mntmDegroupMenuItem = new JMenuItem("deGroup");
		mntmDegroupMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getActionCommand());
						panel.deGroupItem();
					}
				}
		);
		mnEdit.add(mntmDegroupMenuItem);
		JMenuItem mntmClearMenuItem = new JMenuItem("ClearObjects");
		mntmClearMenuItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getActionCommand());
						panel.clearContents();
					}
				}
		);
		mnEdit.add(mntmClearMenuItem);
	}

}
