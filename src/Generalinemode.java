import java.awt.event.MouseEvent;

public class Generalinemode extends Mode{

	public Generalinemode(int mode, Canvas canvas) {
		super(mode, canvas);
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
		for(int i=0;i<this.getCanvas().getShapeArrayList().size();i++) {
			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(((BasicObject) this.getCanvas().getShapeArrayList().get(i)).contain(this.getCanvas().getClick_x(),this.getCanvas().getClick_y())) {
				startPoint = ((BasicObject) this.getCanvas().getShapeArrayList().get(i)).getNearestCheckPoint(this.getCanvas().getClick_x(),this.getCanvas().getClick_y());
			}
		}
		for(int i=0;i<this.getCanvas().getShapeArrayList().size();i++) {
			if(this.getCanvas().getShapeArrayList().get(i).getObjectid()==1) {
				continue;
			}
			if(((BasicObject) this.getCanvas().getShapeArrayList().get(i)).contain(e.getX(),e.getY())) {
				endPoint = ((BasicObject) this.getCanvas().getShapeArrayList().get(i)).getNearestCheckPoint(e.getX(),e.getY());
			}
		}
		///mode///
		if(startPoint.getBelongTo() != endPoint.getBelongTo() && startPoint.getBelongTo()!= -1 && endPoint.getBelongTo()!= -1) {
			this.getCanvas().getShapeArrayList().add(new Composition_Line(startPoint, endPoint, this.getCanvas().getDotSize(),this.getCanvas().getShapeArrayList().size()+1));
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
