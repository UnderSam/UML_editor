package gui;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import shape.Line;

@SuppressWarnings("serial")
public class checkPoint extends Point{
	private static int selectedDotSize;
	private ArrayList<Line> lines;
	private int belongTo;
	public checkPoint(int x,int y,int belongTo,int dotSize) {
		// TODO Auto-generated constructor stub
		this.setLines(new ArrayList<Line>());
		this.setLocation(x, y);
		this.setBelongTo(belongTo);
		this.setSelectedDotSize(dotSize);
	}
	public checkPoint() {
		this.setBelongTo(-1);
	}
	public int getBelongTo() {
		return belongTo;
	}
	public void setBelongTo(int belongTo) {
		this.belongTo = belongTo;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	public void addLines(Line line) {
		this.getLines().add(line);
	}
	public void draw(Graphics G) {
		G.fillRect((int)this.getX(), (int)this.getY(), this.getSelectedDotSize(), this.getSelectedDotSize());
	}
	public int getSelectedDotSize() {
		return selectedDotSize;
	}
	public void setSelectedDotSize(int selectedDotSize) {
		checkPoint.selectedDotSize = selectedDotSize;
	}

}
