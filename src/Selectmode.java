import java.awt.event.MouseEvent;
public class Selectmode extends Mode{

	public Selectmode(int mode) 
	{
		super(mode);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("mouseDragged");
    	if(this.getCanvas().getIsSelectItem()) 
    	{
    		//System.out.println("DraggedItem");
    		for(Shape item:this.getCanvas().getShapeArrayList()) {
    			if(item.isSelected()) {
    				int click_x = this.getCanvas().getClick_x();
					int click_y = this.getCanvas().getClick_y();
					int moved_x = e.getX();
					int moved_y = e.getY();
					item.pointMoved(moved_x-click_x,moved_y-click_y);
    			}
    		}
    		this.getCanvas().setClick_x(e.getX());
    		this.getCanvas().setClick_y(e.getY());
    	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(!this.getCanvas().getIsSelectItem()) {	
			int leftX = e.getX() > this.getCanvas().getClick_x() ? this.getCanvas().getClick_x():e.getX();
			int rightX = e.getX() > this.getCanvas().getClick_x() ? e.getX() : this.getCanvas().getClick_x();
			int upY = e.getY() > this.getCanvas().getClick_y() ? this.getCanvas().getClick_y() : e.getY();
			int downY = e.getY() > this.getCanvas().getClick_y() ? e.getY() : this.getCanvas().getClick_y();
			
			for(Shape item:this.getCanvas().getShapeArrayList()) {
				if(item.isin(leftX,upY,rightX,downY)) {
					item.setSelected(true);
					this.getCanvas().setIsSelectItem(true);
				}
				else {
					item.setSelected(false);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.getCanvas().diselectShapeList();
		this.getCanvas().repaint();
		this.getCanvas().setClick_x(e.getX());
		this.getCanvas().setClick_y(e.getY());
		this.getCanvas().checkSelectedItem(e);
	}	
}
