import java.awt.Graphics;

public abstract class Shape {
	private int depth;
	private int x;
	private int y;
	public Shape(int x,int y,int depth) {
		// TODO Auto-generated constructor stub
		this.setDepth(depth);
		this.setX(x);
		this.setY(y);
	}
	public abstract void draw(Graphics G);
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
