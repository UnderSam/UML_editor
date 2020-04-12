import java.awt.Graphics;
import java.awt.Point;

public class Generalization_Line extends Line{

	public Generalization_Line(Point start,Point end,int dotSize) {
		// TODO Auto-generated constructor stub
		super(start,end,dotSize);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		this.drawLine(g);
	}

}
