import java.awt.event.MouseEvent;
public abstract class Mode {
	private int mode;
	private Canvas canvas;
	public Mode(int mode,Canvas canvas) {
		this.setCanvas(canvas);
		this.setMode(mode);
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public abstract void mouseDragged(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
