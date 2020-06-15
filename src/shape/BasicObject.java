package shape;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import gui.checkPoint;

public class BasicObject extends Shape{

	private String name;

	private int selectedDotSize;
	private int check_width;
	private int check_height;
	private int x;
	private int y;
	private checkPoint[] checkPoint;
	private static int objectID = 0; //rect
	public BasicObject(String name,int x,int y,int depth,int width,int height,int dotSize) {
		// TODO Auto-generated constructor stub
		super(depth,objectID);
		this.x=x;
		this.y=y;
		this.setName(name);
		this.setSelectedDotSize(dotSize);
		this.setCheck_width(width);
		this.setCheck_height(height);
		this.setCheckPoint(new checkPoint[] {
				new checkPoint(x+width/2-this.selectedDotSize/2,y-this.selectedDotSize/2,depth,dotSize), //top
				new checkPoint(x-this.selectedDotSize/2,y+height/2-this.selectedDotSize/2,depth,dotSize), // left
				new checkPoint(x+width-this.selectedDotSize/2,y+height/2-this.selectedDotSize/2,depth,dotSize), //right
				new checkPoint(x+width/2-this.selectedDotSize/2,y+height-this.selectedDotSize/2,depth,dotSize) // down
		});
	}

	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		
	}
	public void drawCenteredString(Graphics g, String text, int x,int y, int width, int height) {
		Font font = new Font(Font.DIALOG, Font.BOLD, 15);
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int draw_x = x + (width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int draw_y = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, draw_x, draw_y);
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
	public boolean contain(int x,int y) {
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
	public void drawPort(Graphics G) {
		for(checkPoint port:this.getCheckPoint()) {
			port.draw(G);
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
