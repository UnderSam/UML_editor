package shape;
import java.awt.Color;
import java.awt.Graphics;

public class UseCaseObject extends BasicObject{
	
	private int radius;
	
	public UseCaseObject(String name,int x,int y,int depth,int radius,int dotSize) {
		super(name,x,y,depth,radius*2,radius*2,dotSize);
		// TODO Auto-generated constructor stub
		this.setRadius(radius);
	}
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		G.setColor(Color.white);
		G.fillOval(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2);
		G.setColor(Color.black);
		G.drawOval(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2);
		if(this.isSelected()) {
			this.drawPort(G);
		}
		this.drawCenteredString(G, this.getName(), this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2);
	}
}
