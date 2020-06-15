package shape;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.checkPoint;

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
	public boolean contain(int x,int y) {
		return false;
	};
	public void pointMoved(int moved_X,int moved_Y) {};
	public Boolean isin(int x,int y,int x2,int y2) {
		return false;
	};
	public checkPoint getNearestCheckPoint(int x,int y) {
		return new checkPoint();
	}
	public ArrayList<Shape> deGroup() {
		return new ArrayList<Shape>();
	}
	public void setName(String name) {
	}
}
