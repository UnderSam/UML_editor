import java.awt.event.MouseEvent;
public class Selectmode extends Mode{

	public Selectmode(int mode,Canvas canvas) 
	{
		super(mode, canvas);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("mouseDragged");
    	if(this.getCanvas().getIsSelectItem()) 
    	{
    		//System.out.println("DraggedItem");
    		for(int i=0;i<this.getCanvas().getShapeArrayList().size();i++) 
    		{
    			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==1) 
    			{
					continue;
				}
				if((this.getCanvas().getShapeArrayList().get(i)).isSelected()) 
				{

					int click_x = this.getCanvas().getClick_x();
					int click_y = this.getCanvas().getClick_y();
					int moved_x = e.getX();
					int moved_y = e.getY();

					((BasicObject) this.getCanvas().getShapeArrayList().get(i)).pointMoved(moved_x-click_x,moved_y-click_y);
				}
			}
    		this.getCanvas().setClick_x(e.getX());
    		this.getCanvas().setClick_y(e.getY());
    	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(int i=0;i<this.getCanvas().getShapeArrayList().size();i++) {
			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==0) {
				if(((BasicObject) this.getCanvas().getShapeArrayList().get(i)).contain(this.getCanvas().getClick_x(),this.getCanvas().getClick_y())) {
					((BasicObject) this.getCanvas().getShapeArrayList().get(i)).getNearestCheckPoint(this.getCanvas().getClick_x(),this.getCanvas().getClick_y());
				}
			}
		}
		for(int i=0;i<this.getCanvas().getShapeArrayList().size();i++) {
			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==0) {
				if(((BasicObject) this.getCanvas().getShapeArrayList().get(i)).contain(e.getX(),e.getY())) {
					((BasicObject) this.getCanvas().getShapeArrayList().get(i)).getNearestCheckPoint(e.getX(),e.getY());
				}
			}
		}
		////mode///
		if(!this.getCanvas().getIsSelectItem()) {
			
			int leftX = e.getX() > this.getCanvas().getClick_x() ? this.getCanvas().getClick_x():e.getX();
			int rightX = e.getX() > this.getCanvas().getClick_x() ? e.getX() : this.getCanvas().getClick_x();
			int upY = e.getY() > this.getCanvas().getClick_y() ? this.getCanvas().getClick_y() : e.getY();
			int downY = e.getY() > this.getCanvas().getClick_y() ? e.getY() : this.getCanvas().getClick_y();

			for(int i=0;i<this.getCanvas().getShapeArrayList().size();i++) {
				if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==1) {
					continue;
				}
				if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==0) {
					if(((BasicObject) this.getCanvas().getShapeArrayList().get(i)).isin(leftX,upY,rightX,downY)) {
						( this.getCanvas().getShapeArrayList().get(i)).setSelected(true);
						this.getCanvas().setIsSelectItem(true);
					}else {
						( this.getCanvas().getShapeArrayList().get(i)).setSelected(false);
					}
				}
			}
		}
		this.getCanvas().repaint();
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
