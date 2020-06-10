import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GroupObject extends Shape{
	private int depth;
	private static int objectid = 2;
	private ArrayList<Shape> groupArrayList;
	public GroupObject(int depth) {
		super(depth,objectid);
		// TODO Auto-generated constructor stub
		this.setDepth(depth);
		this.setGroupArrayList(new ArrayList<Shape>());
	}
	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		for(Shape object:groupArrayList) {
			object.draw(G);
		}
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public ArrayList<Shape> getGroupArrayList() {
		return groupArrayList;
	}
	public void setGroupArrayList(ArrayList<Shape> groupArrayList) {
		this.groupArrayList = groupArrayList;
	}
	public void addchild(Shape object) {
		this.getGroupArrayList().add(object);
	}
	@Override
	public void setSelected(boolean isSelected) {
		super.setSelected(isSelected);
		for(Shape object : this.groupArrayList) {
			object.setSelected(isSelected);
		}
	}
	public boolean contain(MouseEvent e) {
		System.out.println("Check group contain");
		boolean isContain=false;
		for(Shape item:this.getGroupArrayList()) {
			System.out.println("Check item "+item.getObjectid());
			if(item.getObjectid()==0) {
				if(((BasicObject)item).contain(e.getX(), e.getY())) {
					isContain = true;
					break;
				}
			}
			else if(item.getObjectid()==2) {
				if(this.contain(e)) {
					isContain = true;
					break;
				}
			}
		}
		System.out.println("return group contain : "+isContain);
		return isContain;
	}
}
