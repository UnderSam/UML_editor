import java.awt.Point;

@SuppressWarnings("serial")
public class checkPoint extends Point{

	private int belongTo;
	public checkPoint(int x,int y,int belongTo) {
		// TODO Auto-generated constructor stub
		this.setLocation(x, y);
		this.setBelongTo(belongTo);
	}
	public checkPoint() {
		this.setBelongTo(-1);
	}
	public int getBelongTo() {
		return belongTo;
	}
	public void setBelongTo(int belongTo) {
		this.belongTo = belongTo;
	}

}
