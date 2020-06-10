import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Canvas extends JPanel{
	private ArrayList<Shape> shapeArrayList;
	private ArrayList<ArrayList<Shape>> groupShapeList;
	private int click_x;
	private int click_y;
	private Boolean isSelectItem;
	int CircleRadius;
	int RectWidth;
	int RectHeight;
	int dotSize;
	private GUI myGUI;
	public Canvas(GUI myGUI) {
		CircleRadius = 40;
		RectWidth = 90;
		RectHeight = 30;
		dotSize = 10;
		// TODO Auto-generated constructor stub
		this.setMyGUI(myGUI);
		this.setShapeArrayList(new ArrayList<Shape>());
		this.setGroupShapeList(new ArrayList<ArrayList<Shape>>());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(187, 41, 753, 484);
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
		    public void mouseDragged(MouseEvent e) {
				myGUI.getButtonList().get(myGUI.getMode()).getModer().mouseDragged(e);
				repaint();
		    }
			@Override
		    public void mouseMoved(MouseEvent e) {
		    }
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("mouseRelease");
				myGUI.getButtonList().get(myGUI.getMode()).getModer().mouseReleased(e);
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
		        //System.out.println("mouseClicked");
		    }
			@Override
		    public void mousePressed(MouseEvent e) {
				myGUI.getButtonList().get(myGUI.getMode()).getModer().mousePressed(e);
				repaint();
		    }
		});	
	}
	public void checkSelectedItem(MouseEvent e) {
		setIsSelectItem(false);
		// set selected item by order
		int max_depth = -999;
		int max_index = -1;
		
		for(int i=0;i<getShapeArrayList().size();i++) {
			if(getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(getShapeArrayList().get(i).getObjectid()==0) {
				if(((BasicObject) getShapeArrayList().get(i)).contain(e.getX(),e.getY())) {
					if(getShapeArrayList().get(i).getDepth() > max_depth) {
						max_depth = getShapeArrayList().get(i).getDepth();
						max_index = i;
					}
					setIsSelectItem(true);
				}else {
					getShapeArrayList().get(i).setSelected(false);
				}
			}
			else if(getShapeArrayList().get(i).getObjectid()==2) {
				System.out.println("Check group");
				if(((GroupObject)getShapeArrayList().get(i)).contain(e)) {
					setIsSelectItem(true);
					max_index = i;
				}else {
					getShapeArrayList().get(i).setSelected(false);
				}
			}
		}
		if(max_index != -1) {
			diselectShapeList();
			getShapeArrayList().get(max_index).setSelected(true);
		}
	}
	public int countSelect() {
		int count = 0;
		for(Shape item:this.getShapeArrayList()) {
			if(item.isSelected()) count++;
		}
		return count;
	}
	public void diselectShapeList() {
		System.out.println("diselect");
		for(Shape item:this.getShapeArrayList()) {
			item.setSelected(false);
		}

	}
	public void groupItem() {
		System.out.println(this.countSelect());
		if(this.countSelect()<2) { // check must two obj be selected
			return;
		}
		GroupObject newGroup = new GroupObject(this.getShapeArrayList().size()+1);
		for(Shape item:this.getShapeArrayList()) {
			if(item.getObjectid()!=1 && item.isSelected()) {
				newGroup.addchild(item);
			}
		}
		for(Shape item:newGroup.getGroupArrayList()) {
			this.getShapeArrayList().remove(item);
		}
		this.getShapeArrayList().add(newGroup);
		System.out.println(this.getShapeArrayList());
	}
	public void deGroupItem() {
		int cursor_x = this.getClick_x();
		int cursor_y = this.getClick_y();
		for(int i=0;i<getShapeArrayList().size();i++) {
			if(getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(((BasicObject) getShapeArrayList().get(i)).contain(cursor_x,cursor_y)) {
				for(int j=this.getGroupShapeList().size()-1;j>=0;j--) {
					if(this.getGroupShapeList().get(j).contains(getShapeArrayList().get(i))) {
						this.getGroupShapeList().remove(j);
						break;
					}
				}
				break;
			}
		}
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        for(Shape element : this.getShapeArrayList()) {
        	element.draw(g);
        }
    }
	public boolean isInGroup(Shape select_item) {
		boolean result = false;
		for(int i=this.getGroupShapeList().size()-1;i>=0;i--) {
			if(this.getGroupShapeList().get(i).contains(select_item)) {
				result = true;
				break;
			}
		}
		return result;
	}
	public int getDotSize() {
		return this.dotSize;
	}
	public void changeNameDialog(String name) {
		for(int i=0;i < this.getShapeArrayList().size();i++) {
			if(getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(((BasicObject) this.getShapeArrayList().get(i)).contain(this.getClick_x(),this.getClick_y()) && this.getShapeArrayList().get(i).isSelected()) {
				if(!this.isInGroup(this.getShapeArrayList().get(i))) {
					//rename if item is not in group
					((BasicObject) this.getShapeArrayList().get(i)).setName(name);
				}
				break;
			}
		}
		repaint();
	}
	public ArrayList<Shape> getShapeArrayList() {
		return shapeArrayList;
	}
	public void setShapeArrayList(ArrayList<Shape> shapeArrayList) {
		this.shapeArrayList = (ArrayList<Shape>) shapeArrayList;
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
	public ArrayList<ArrayList<Shape>> getGroupShapeList() {
		return groupShapeList;
	}
	public void setGroupShapeList(ArrayList<ArrayList<Shape>> groupShapeList) {
		this.groupShapeList = groupShapeList;
	}
	public void clearContents() {
		// TODO Auto-generated method stub
		this.getShapeArrayList().clear();
		this.getGroupShapeList().clear();
		this.diselectShapeList();
		repaint();
	}
	public GUI getMyGUI() {
		return myGUI;
	}
	public void setMyGUI(GUI myGUI) {
		this.myGUI = myGUI;
	}  

}