package mode;
import java.awt.event.MouseEvent;

import gui.Canvas;
import gui.GUI;
public abstract class Mode {
	private int mode;
	public Mode(int mode) {
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
		return GUI.getInstance().getCanvas();
	}

}
