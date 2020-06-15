package mode;
import java.awt.event.MouseEvent;

import shape.ClassObject;

public class Classobjmode extends Mode{

	public Classobjmode(int mode) {
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
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.getCanvas().diselectShapeList();
		this.getCanvas().repaint();
		this.getCanvas().setClick_x(e.getX());
		this.getCanvas().setClick_y(e.getY());
		this.getCanvas().getShapeArrayList().add(new ClassObject("", e.getX(), e.getY(), this.getCanvas().getShapeArrayList().size()+1, this.getCanvas().getRectWidth(), this.getCanvas().getRectHeight(), this.getCanvas().getDotSize()));
	}

}
