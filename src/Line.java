import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 */

/**
 * @author ChengJu
 *
 */
public abstract class Line {

	/**
	 * 
	 */
	private Point startPoint;
	private Point endPoint;
	private int bold;
	int dotSize;
	public Line(Point start,Point end,int dotSize) {
		// TODO Auto-generated constructor stub
		this.setStartPoint(start);
		this.setEndPoint(end);
		this.setBold(3);
		this.dotSize = dotSize;
	}
	public abstract void draw(Graphics g);
	public void drawLine(Graphics g) {
		g.drawLine(this.getStartPoint().x+dotSize/2, this.getStartPoint().y+dotSize/2, this.getEndPoint().x+dotSize/2, this.getEndPoint().y+dotSize/2);
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	public int getBold() {
		return bold;
	}
	public void setBold(int bold) {
		this.bold = bold;
	}

}
