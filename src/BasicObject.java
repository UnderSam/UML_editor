import java.awt.Graphics;

public class BasicObject extends Shape{

	private String name;
	private boolean isSelected;
	private int selectedDotSize;
	private int check_width;
	private int check_height;
	private checkPoint[] checkPoint;
	public BasicObject(String name,int x,int y,int depth,int width,int height,int dotSize) {
		// TODO Auto-generated constructor stub
		super(x,y,depth);
		this.setName(name);
		this.setSelected(false);
		this.setSelectedDotSize(dotSize);
		this.setCheck_width(width);
		this.setCheck_height(height);
		this.setCheckPoint(new checkPoint[] {
				new checkPoint(x+width/2-this.selectedDotSize/2,y-this.selectedDotSize/2,depth), //top
				new checkPoint(x-this.selectedDotSize/2,y+height/2-this.selectedDotSize/2,depth), // left
				new checkPoint(x+width-this.selectedDotSize/2,y+height/2-this.selectedDotSize/2,depth), //right
				new checkPoint(x+width/2-this.selectedDotSize/2,y+height-this.selectedDotSize/2,depth) // down
		});
	}

	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		
	}
	
	public checkPoint getNearestCheckPoint(int x,int y) {
		double leastDistance = 999;
		int nearestIndex = -1;
		for(int i=0; i < this.getCheckPoint().length; i++) {
			double distance = Math.sqrt((y - this.getCheckPoint()[i].getY()) * (y - this.getCheckPoint()[i].getY()) + (x - this.getCheckPoint()[i].getX()) * (x - this.getCheckPoint()[i].getX()));
			//System.out.println("point "+i+" distance : "+distance);
			if(distance < leastDistance) {
				leastDistance = distance;
				nearestIndex = i;
			}
		}
		//Point returnPoint = new Point(this.getCheckPoint()[nearestIndex].x+this.getSelectedDotSize()/2,this.getCheckPoint()[nearestIndex].y+this.getSelectedDotSize()/2);
		return this.getCheckPoint()[nearestIndex];
	}
	
	public void pointMoved(int moved_X,int moved_Y) {
//		if(this.getX()+moved_X < 0 || this.getY()+moved_Y<0) {
//			return;
//		}
		this.setX(this.getX()+moved_X);
		this.setY(this.getY()+moved_Y);
		for(int i=0; i < this.getCheckPoint().length ; i++) {
			this.getCheckPoint()[i].setLocation(this.getCheckPoint()[i].getX()+moved_X, this.getCheckPoint()[i].getY()+moved_Y);
		}
	}
	public Boolean contain(int x,int y) {
		Boolean isSelect = false;
		if(x > this.getX() && x < this.getX()+this.getCheck_width() && y > this.getY() && y < this.getY()+this.getCheck_height()) {
			isSelect = true;
		}
		return isSelect;
	}
	public Boolean isin(int x,int y,int x2,int y2) {
		Boolean isIn = false;
		if(this.getX() > x && this.getY() > y && this.getX()+this.getCheck_width() < x2 && this.getY()+this.getCheck_height() < y2) {
			isIn = true;
		}
		return isIn;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public int getSelectedDotSize() {
		return selectedDotSize;
	}

	public void setSelectedDotSize(int selectedDotSize) {
		this.selectedDotSize = selectedDotSize;
	}

	public int getCheck_height() {
		return check_height;
	}

	public void setCheck_height(int check_height) {
		this.check_height = check_height;
	}

	public int getCheck_width() {
		return check_width;
	}

	public void setCheck_width(int check_width) {
		this.check_width = check_width;
	}

	public checkPoint[] getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(checkPoint[] checkPoint) {
		this.checkPoint = checkPoint;
	}



}
