import java.awt.Graphics;

public abstract class Shape {
	private int depth; //objectID
	private int objectid;
	private boolean isSelected = false;
	public Shape(int depth,int objectid) {
		// TODO Auto-generated constructor stub
		this.setDepth(depth);
		this.setObjectid(objectid);
	}
	public abstract void draw(Graphics G);
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getObjectid() {
		return objectid;
	}
	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
