package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import shape.Shape;

@SuppressWarnings("serial")
public class Canvas extends JPanel{
	private ArrayList<Shape> shapeArrayList;
	private ArrayList<ArrayList<Shape>> groupShapeList;
	private int click_x;
	private int click_y;
	private Boolean isSelectItem;
	private int CircleRadius;
	private int RectWidth;
	private int RectHeight;
	int dotSize;
	private Comparator<Shape> c;
	public Canvas() {
		setCircleRadius(40);
		setRectWidth(90);
		setRectHeight(30);
		dotSize = 10;
		// TODO Auto-generated constructor stub
		this.setC(new Comparator<Shape>() {
			@Override
			public int compare(Shape s1,Shape s2) {
				if(s1.getDepth()>s2.getDepth()) {
					return 1;
				}
				else return -1; 
			} 
		});
		this.setShapeArrayList(new ArrayList<Shape>());
		this.setGroupShapeList(new ArrayList<ArrayList<Shape>>());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(187, 41, 753, 484);
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
		    public void mouseDragged(MouseEvent e) {
				GUI.getInstance().getButtonList().get(GUI.getInstance().getMode()).getModer().mouseDragged(e);
				repaint();
		    }
			@Override
		    public void mouseMoved(MouseEvent e) {
		    }
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("mouseRelease");
				GUI.getInstance().getButtonList().get(GUI.getInstance().getMode()).getModer().mouseReleased(e);
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
		        //System.out.println("mouseClicked");
		    }
			@Override
		    public void mousePressed(MouseEvent e) {
				GUI.getInstance().getButtonList().get(GUI.getInstance().getMode()).getModer().mousePressed(e);
				repaint();
		    }
		});	
	}
	public void checkSelectedItem(MouseEvent e) {
		setIsSelectItem(false);
		// set selected item by order
		int max_depth = -999;
		Shape max_shape = null;
		
		for(Shape item:this.getShapeArrayList()) {
			System.out.println(item.contain(e.getX(),e.getY()));
			if(item.contain(e.getX(),e.getY())) {
				if(item.getDepth() > max_depth) {
					max_depth = item.getDepth();
					max_shape = item;
				}
				setIsSelectItem(true);
			}else {
				item.setSelected(false);
			}
		}
		if(max_shape != null) {
			diselectShapeList();
			max_shape.setSelected(true);
		}
	}
	public int countSelect() {
		int count = 0;
		for(Shape item:this.getShapeArrayList()) {
			if(item.isSelected()) count++;
		}
		return count;
	}
	public void diselectShapeList() {
		System.out.println("diselect");
		for(Shape item:this.getShapeArrayList()) {
			item.setSelected(false);
		}

	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(Shape element : this.getShapeArrayList()) {
        	element.draw(g);
        }
    }
	public int getDotSize() {
		return this.dotSize;
	}
	public ArrayList<Shape> getShapeArrayList() {
		return shapeArrayList;
	}
	public void setShapeArrayList(ArrayList<Shape> shapeArrayList) {
		this.shapeArrayList = (ArrayList<Shape>) shapeArrayList;
	}
	public int getClick_x() {
		return click_x;
	}
	public void setClick_x(int click_x) {
		this.click_x = click_x;
	}
	public int getClick_y() {
		return click_y;
	}
	public void setClick_y(int click_y) {
		this.click_y = click_y;
	}
	public Boolean getIsSelectItem() {
		return isSelectItem;
	}
	public void setIsSelectItem(Boolean isSelectItem) {
		this.isSelectItem = isSelectItem;
	}
	public ArrayList<ArrayList<Shape>> getGroupShapeList() {
		return groupShapeList;
	}
	public void setGroupShapeList(ArrayList<ArrayList<Shape>> groupShapeList) {
		this.groupShapeList = groupShapeList;
	}
	public Comparator<Shape> getC() {
		return c;
	}
	public void setC(Comparator<Shape> c) {
		this.c = c;
	}
	public int getRectWidth() {
		return RectWidth;
	}
	public void setRectWidth(int rectWidth) {
		RectWidth = rectWidth;
	}
	public int getRectHeight() {
		return RectHeight;
	}
	public void setRectHeight(int rectHeight) {
		RectHeight = rectHeight;
	}
	public int getCircleRadius() {
		return CircleRadius;
	}
	public void setCircleRadius(int circleRadius) {
		CircleRadius = circleRadius;
	}
}