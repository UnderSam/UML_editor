import java.awt.Graphics;

public class BasicObject extends Shape{

	private String name;
	private boolean isSelected;
	private int selectedDotSize;
	private int check_width;
	private int check_height;
	
	public BasicObject(String name,int x,int y,int depth,int width,int height) {
		// TODO Auto-generated constructor stub
		super(x,y,depth);
		this.setName(name);
		this.setSelected(false);
		this.setSelectedDotSize(10);
		this.setCheck_width(width);
		this.setCheck_height(height);
	}

	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		
	}
	public Boolean isin(int x,int y) {
		Boolean isSelect = false;
		if(x > this.getX() && x < this.getX()+this.getCheck_width() && y > this.getY() && y < this.getY()+this.getCheck_height()) {
			isSelect = true;
		}
		return isSelect;
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



}
