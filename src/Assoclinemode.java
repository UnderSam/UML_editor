import java.awt.event.MouseEvent;

public class Assoclinemode extends Mode{

	public Assoclinemode(int mode) {
		super(mode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		checkPoint startPoint = new checkPoint();
		checkPoint endPoint = new checkPoint();
		for(Shape item:this.getCanvas().getShapeArrayList()) {
			if(item.contain(this.getCanvas().getClick_x(),this.getCanvas().getClick_y())) {
				startPoint = item.getNearestCheckPoint(this.getCanvas().getClick_x(),this.getCanvas().getClick_y());
			}
			if(item.contain(e.getX(),e.getY())) {
				endPoint = item.getNearestCheckPoint(e.getX(),e.getY());
			}
		}
		///mode///
		if(startPoint.getBelongTo() != endPoint.getBelongTo() && startPoint.getBelongTo()!= -1 && endPoint.getBelongTo()!= -1) {
			this.getCanvas().getShapeArrayList().add(new Association_Line(startPoint, endPoint, this.getCanvas().getDotSize(),this.getCanvas().getShapeArrayList().size()+1));
		}
		this.getCanvas().diselectShapeList();
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
