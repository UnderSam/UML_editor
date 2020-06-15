package shape;
import java.awt.Graphics;
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
	public boolean contain(int x,int y) {
		boolean isContain=false;
		for(Shape item:this.getGroupArrayList()) {
			if(item.contain(x, y)) {
				isContain = true;
				break;
			}
		}
		return isContain;
	}
	public void pointMoved(int moved_X,int moved_Y) {
		for(Shape item:this.getGroupArrayList()) {
			item.pointMoved(moved_X, moved_Y);
		}
	}
	public Boolean isin(int x,int y,int x2,int y2) {
		boolean isIn = false;
		for(Shape item:this.getGroupArrayList()) {
			if(item.isin(x,y,x2,y2)) {
				isIn = true;
				break;
			}
		}
		return isIn;
	}
	public checkPoint getNearestCheckPoint(int x,int y) {
		checkPoint nearestPort= new checkPoint();
		for(Shape item:this.getGroupArrayList()) {
			if(item.contain(x, y)) {
				nearestPort = item.getNearestCheckPoint(x, y);
				break;
			}
		}
		return nearestPort;
	}
	public ArrayList<Shape> deGroup() {
		return this.getGroupArrayList();
	}
}
