import java.awt.Graphics;

public class UseCaseObject extends BasicObject{
	
	private int radius;
	
	public UseCaseObject(String name,int x,int y,int depth,int radius) {
		super(name,x,y,depth,radius*2,radius*2);
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
		int offset = this.getSelectedDotSize()/2;
		G.drawOval(this.getX(), this.getY(), this.getRadius()*2, this.getRadius()*2);
		if(this.isSelected()) {
			G.fillRect(this.getX()-offset, this.getY()+this.getRadius()-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // left 
			G.fillRect(this.getX()+this.getRadius()*2-offset, this.getY()+this.getRadius()-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // right 
			G.fillRect(this.getX()+this.getRadius()-offset, this.getY()-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // up
			G.fillRect(this.getX()+this.getRadius()-offset, this.getY()+this.getRadius()*2-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // down
		}
	}
}
