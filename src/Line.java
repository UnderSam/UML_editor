import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 */

/**
 * @author ChengJu
 *
 */
public abstract class Line extends Shape{

	/**
	 * 
	 */
	private checkPoint startPoint;
	private checkPoint endPoint;
	private int bold;
	private int dotSize;
	private double scaler;
	private static int objectID = 1; //line
	public Line(checkPoint start,checkPoint end,int dotSize,int depth) {
		// TODO Auto-generated constructor stub
		super(depth,objectID);
		this.setStartPoint(start);
		this.setEndPoint(end);
		this.setBold(3);
		this.dotSize = dotSize;
		this.setScaler(9.0/10);
	}
	public abstract void draw(Graphics g);
	public void drawLine(Graphics g) {
		g.drawLine(this.getStartPoint().x+dotSize/2, this.getStartPoint().y+dotSize/2, this.getEndPoint().x+dotSize/2, this.getEndPoint().y+dotSize/2);
	}
	public double getDistance() {
		double distance = Math.sqrt((this.getEndPoint().getY() - this.getStartPoint().getY()) * (this.getEndPoint().getY() - this.getStartPoint().getY()) + (this.getEndPoint().getX() - this.getStartPoint().getX()) * (this.getEndPoint().getX() - this.getStartPoint().getX()));
		return distance;
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public double getNormStartX() {
		//double new_start_x = (1-this.getScaler())*this.getStartPoint().getX()+(this.getScaler())*this.getEndPoint().getX();
		double new_start_x = this.getStartPoint().getX()+(this.getEndPoint().getX()-this.getStartPoint().getX())/(0.1)*(this.getDistance())+1;
		return new_start_x;
	}
	public double getNormStartY() {
		//double new_start_y = (1-this.getScaler())*this.getStartPoint().getY()+(this.getScaler())*this.getEndPoint().getY();
		double new_start_y = this.getStartPoint().getY()+(this.getEndPoint().getY()-this.getEndPoint().getY())/(0.1)*(this.getDistance())+1;
		return new_start_y;
	}
	public void setStartPoint(checkPoint startPoint) {
		this.startPoint = startPoint;
		startPoint.getLines().add(this);
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(checkPoint endPoint) {
		this.endPoint = endPoint;
		endPoint.getLines().add(this);
	}
	public int getBold() {
		return bold;
	}
	public int getDotSize() {
		return this.dotSize;
	}
	public void setBold(int bold) {
		this.bold = bold;
	}
	public double getScaler() {
		return scaler;
	}
	public void setScaler(double scaler) {
		this.scaler = scaler;
	}

}
