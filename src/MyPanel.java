import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MyPanel extends JPanel{
	private ArrayList<Shape> shapeArrayList;
	private int click_x;
	private int click_y;
	private Boolean isSelectItem;
	public MyPanel(GUI myGUI) {
		// TODO Auto-generated constructor stub
		this.setShapeArrayList(new ArrayList<Shape>());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(187, 41, 753, 484);
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
		    // from MouseWheelListener
		    public void mouseWheelMoved(MouseWheelEvent e) {
		        System.out.println("mouseWheelMoved");
		    }
			@Override
		    public void mouseDragged(MouseEvent e) {
		        int mode = myGUI.getMode();
		        if (mode==0) {
		        	//System.out.println("mouseDragged");
		        	if(getIsSelectItem()) {
		        		//System.out.println("DraggedItem");
		        		for(int i=0;i<getShapeArrayList().size();i++) {
							if(((BasicObject) getShapeArrayList().get(i)).isSelected()) {
								int current_x = getShapeArrayList().get(i).getX();
								int current_y = getShapeArrayList().get(i).getY();
								int click_x = getClick_x();
								int click_y = getClick_y();
								int moved_x = e.getX();
								int moved_y = e.getY();
		
								getShapeArrayList().get(i).setX(current_x+(moved_x-click_x));
								getShapeArrayList().get(i).setY(current_y+(moved_y-click_y));
								
							}
						}
		        		setClick_x(e.getX());
			        	setClick_y(e.getY());
		        	}else {
		        		//System.out.println("SelectItem");
		        	}
		        	repaint();
		        }
		    }
			@Override
		    public void mouseMoved(MouseEvent e) {
		        //System.out.println("mouseMoved");
		    }
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseRelease");
				int mode = myGUI.getMode();
				if(mode==0) {
					if(!getIsSelectItem()) {
						System.out.println("SelectReleased");
						int leftX = e.getX() > getClick_x() ? getClick_x():e.getX();
						int rightX = e.getX() > getClick_x() ? e.getX() : getClick_x();
						int upY = e.getY() > getClick_y() ? getClick_y() : e.getY();
						int downY = e.getY() > getClick_y() ? e.getY() : getClick_y();
//						System.out.println(leftX);
//						System.out.println(rightX);
//						System.out.println(upY);
//						System.out.println(downY);
						for(int i=0;i<getShapeArrayList().size();i++) {
							if(((BasicObject) getShapeArrayList().get(i)).isin(leftX,upY,rightX,downY)) {
								((BasicObject) getShapeArrayList().get(i)).setSelected(true);
								setIsSelectItem(true);
							}else {
								((BasicObject) getShapeArrayList().get(i)).setSelected(false);
							}
						}
						repaint();
					}
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
		        System.out.println("mouseClicked");
		    }
			@Override
		    public void mousePressed(MouseEvent e) {
		        System.out.println("mousePressed");
		        int mode = myGUI.getMode();
				switch(mode){
					case 0:
						setIsSelectItem(false);
						setClick_x(e.getX());
						setClick_y(e.getY());
						for(int i=0;i<getShapeArrayList().size();i++) {
							if(((BasicObject) getShapeArrayList().get(i)).contain(e.getX(),e.getY())) {
								((BasicObject) getShapeArrayList().get(i)).setSelected(true);
								setIsSelectItem(true);
							}else {
								((BasicObject) getShapeArrayList().get(i)).setSelected(false);
							}
						}
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						getShapeArrayList().add(new ClassObject("default", e.getX(), e.getY(), 0 , 50, 20));
						break;
					case 5:
						getShapeArrayList().add(new UseCaseObject("default", e.getX(), e.getY(), 0, 20)); // radius = 20
						break;
				}
				repaint();
		    }
			@Override
		    public void mouseEntered(MouseEvent e) {
		        System.out.println("mouseEntered");
		    }
			@Override
		    public void mouseExited(MouseEvent e) {
		        System.out.println("mouseExited");
		    }
		});
		
	}
	public ArrayList<Shape> getShapeArrayList() {
		return shapeArrayList;
	}
	public void setShapeArrayList(ArrayList<Shape> shapeArrayList) {
		this.shapeArrayList = (ArrayList<Shape>) shapeArrayList;
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        
        for(int i=0;i<this.getShapeArrayList().size();i++) {
        	//System.out.println(((BasicObject) this.getShapeArrayList().get(i)).isSelected());
        	this.getShapeArrayList().get(i).draw(g);
        }
        
    }
	public int getClick_x() {
		return click_x;
	}
	public void setClick_x(int click_x) {
		this.click_x = click_x;
	}
	public int getClick_y() {
		return click_y;
	}
	public void setClick_y(int click_y) {
		this.click_y = click_y;
	}
	public Boolean getIsSelectItem() {
		return isSelectItem;
	}
	public void setIsSelectItem(Boolean isSelectItem) {
		this.isSelectItem = isSelectItem;
	}  

}