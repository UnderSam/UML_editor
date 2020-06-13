import java.awt.event.MouseEvent;

public class Usecasobjmode extends Mode{

	public Usecasobjmode(int mode) {
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
		this.getCanvas().getShapeArrayList().add(new UseCaseObject("", e.getX(), e.getY(), this.getCanvas().getShapeArrayList().size()+1, this.getCanvas().CircleRadius, this.getCanvas().getDotSize()));
	}

}
