import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Composition_Line extends Line{
	private double theta; 
	public Composition_Line(Point start,Point end,int dotSize,int depth) {
		// TODO Auto-generated constructor stub
		super(start,end,dotSize,depth);
		this.setTheta(270);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		this.drawLine(g);
		this.drawHead(g);
	}
	private void drawHead(Graphics g) {
		int polyCount = 4;
		double distance = this.getDistance();
		double rad = Math.toRadians(this.getTheta());
		double arrow_one_x = ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.cos(rad) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.sin(rad) + this.getStartPoint().getX());
		double arrow_one_y = ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.sin(rad) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.cos(rad) + this.getStartPoint().getY());
		arrow_one_x = this.getEndPoint().getX() - 10*(this.getEndPoint().getX()-arrow_one_x)/distance;
		arrow_one_y = this.getEndPoint().getY() - 10*(this.getEndPoint().getY()-arrow_one_y)/distance;
		
		double rad2 = Math.toRadians(this.getTheta()*-1);
		double arrow_two_x = (int) ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.cos(rad2) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.sin(rad2) + this.getStartPoint().getX());
		double arrow_two_y = (int) ((this.getEndPoint().getX() - this.getStartPoint().getX())*Math.sin(rad2) + (this.getEndPoint().getY() - this.getStartPoint().getY())*(-1)*Math.cos(rad2) + this.getStartPoint().getY());
		arrow_two_x = this.getEndPoint().getX() - 10*(this.getEndPoint().getX()-arrow_two_x)/distance;
		arrow_two_y = this.getEndPoint().getY() - 10*(this.getEndPoint().getY()-arrow_two_y)/distance;
		
		double point_four_x = this.getEndPoint().getX() - 15*(this.getEndPoint().getX()-this.getStartPoint().getX())/distance;
		double point_four_y = this.getEndPoint().getY() - 15*(this.getEndPoint().getY()-this.getStartPoint().getY())/distance;
		
		int[] Polygen_X = new int[] {(int)arrow_one_x,(int)point_four_x,(int)arrow_two_x,(int)this.getEndPoint().getX()}; 
		int[] Polygen_Y = new int[] {(int)arrow_one_y,(int)point_four_y,(int)arrow_two_y,(int)this.getEndPoint().getY()};
		for(int i=0;i<polyCount;i++) {
			Polygen_X[i]+=this.getDotSize()/2;
			Polygen_Y[i]+=this.getDotSize()/2;
		}
		
		g.setColor(Color.white);
		g.fillPolygon(Polygen_X, Polygen_Y, polyCount);
		g.setColor(Color.black);
		g.drawPolygon(Polygen_X, Polygen_Y, polyCount);
	}
	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}
	

}
