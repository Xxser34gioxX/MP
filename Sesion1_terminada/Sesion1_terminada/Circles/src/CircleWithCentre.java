
public class CircleWithCentre {
	private Circle c;
	private Point p;
	
	public CircleWithCentre(int x, int y, int r) {
		c = new Circle(r);
		p = new Point(x, y);
	}
	
	public double getRadio() {
		return c.getRadius();
	}
	public void setRadio(Circle r) {
		setRadio(r);
	}
	
	public int getCentre(Point p) {
		return p;
	}
	public void setCentre(Point p) {
		
	}
		
	public void setCentre(int x, int y) {
		centre = p;
	}
	
	}
	
}
