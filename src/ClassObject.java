import java.awt.Color;
import java.awt.Graphics;

public class ClassObject extends BasicObject{
	
	private int width;
	private int height;
	
	public ClassObject(String name,int x,int y,int depth,int width,int height,int dotSize) {
		super(name,x,y,depth,width,height*3,dotSize);
		// TODO Auto-generated constructor stub
		this.setWidth(width);
		this.setHeight(height);
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		int actual_x = this.getX();
		int actual_y = this.getY();
		for(int i=0;i<3;i++) {
			//drawRect(x,y,width,height)
			G.setColor(Color.white);
			G.fillRect(actual_x, actual_y+i*this.getHeight(), this.getWidth(), this.getHeight());
		}
		for(int i=0;i<3;i++) {
			//drawRect(x,y,width,height)
			G.setColor(Color.black);
			G.drawRect(actual_x, actual_y+i*this.getHeight(), this.getWidth(), this.getHeight());
		}
		if(this.isSelected()) {
			for(int i=0;i<this.getCheckPoint().length;i++) {
				G.fillRect((int)this.getCheckPoint()[i].getX(), (int)this.getCheckPoint()[i].getY(), this.getSelectedDotSize(), this.getSelectedDotSize());
			}
		}
		this.drawCenteredString(G, this.getName(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
