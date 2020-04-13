import java.awt.Graphics;
import java.awt.Point;

public class Association_Line extends Line{

	private double theta; 
  
    // converting values to radians 
	public Association_Line(Point start,Point end,int dotSize) {
		// TODO Auto-generated constructor stub
		super(start,end,dotSize);
		this.setTheta(30);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		this.drawLine(g);
		this.drawHead(g);
	}

	private void drawHead(Graphics g) {
		double rad = Math.toRadians(this.getTheta());
		int arrow_one_x = (int) ((int) (this.getEndPoint().getX() - this.getStartPoint().getX())*Math.cos(rad) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.sin(rad) + this.getStartPoint().getX());
		int arrow_one_y = (int) ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.sin(rad) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.cos(rad) + this.getStartPoint().getY());
		
		double rad2 = Math.toRadians(this.getTheta()*-1);
		int arrow_two_x = (int) ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.cos(rad2) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.sin(rad2) + this.getStartPoint().getX());
		int arrow_two_y = (int) ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.sin(rad2) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.cos(rad2) + this.getStartPoint().getY());
		
		g.drawLine((int)this.getStartPoint().getX(), (int)this.getStartPoint().getY(), arrow_one_x, arrow_one_y);
		g.drawLine((int)this.getStartPoint().getX(), (int)this.getStartPoint().getY(), arrow_two_x, arrow_two_y);
	}
	
	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

}
