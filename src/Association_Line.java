import java.awt.Graphics;

public class Association_Line extends Line{

	private double theta; 
    
    // converting values to radiant 
	public Association_Line(checkPoint start,checkPoint end,int dotSize,int depth) {
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
		
		
		g.drawLine((int)this.getEndPoint().getX()+this.getDotSize()/2, (int)this.getEndPoint().getY()+this.getDotSize()/2, (int)arrow_one_x+this.getDotSize()/2, (int)arrow_one_y+this.getDotSize()/2);
		g.drawLine((int)this.getEndPoint().getX()+this.getDotSize()/2, (int)this.getEndPoint().getY()+this.getDotSize()/2, (int)arrow_two_x+this.getDotSize()/2, (int)arrow_two_y+this.getDotSize()/2);
	}
	
	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}


}
