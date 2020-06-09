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
}
