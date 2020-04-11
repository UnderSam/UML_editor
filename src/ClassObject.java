import java.awt.Graphics;

public class ClassObject extends BasicObject{
	
	private int width;
	private int height;
	
	public ClassObject(String name,int x,int y,int depth,int width,int height) {
		super(name,x,y,depth,width,height*3);
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
		int offset = this.getSelectedDotSize()/2;
		for(int i=0;i<3;i++) {
			//drawRect(x,y,width,height)
			G.drawRect(actual_x, actual_y+i*this.getHeight(), this.getWidth(), this.getHeight());
		}
		if(this.isSelected()) {
			G.fillRect(this.getX()-offset, this.getY()+this.getHeight()+this.getHeight()/2-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // left 
			G.fillRect(this.getX()+this.getWidth()-offset, this.getY()+this.getHeight()+this.getHeight()/2-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // right 
			G.fillRect(this.getX()+this.getWidth()/2-offset, this.getY()-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // up
			G.fillRect(this.getX()+this.getWidth()/2-offset, this.getY()+this.getHeight()*3-offset, this.getSelectedDotSize(), this.getSelectedDotSize()); // down
		}
	}
}
