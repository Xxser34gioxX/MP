public class CircleWithCentre {

	private Circle circle;
	private Point center;

	public CircleWithCentre(int x, int y, double r) {

		circle = new Circle(r);
		center = new Point(x, y);

	}

	public double getRadius() {
		return circle.getRadius();
	}

	public void setRadius(double r) {
		circle.setRadius(r);
	}

	public Point getCentre() {
		return center;
	}

	public void setCentre(Point p) {
		center = p;
	}

	public void setCentre(int x, int y) {
		center.setX(x);
		center.setY(y);
	}
	
	public double perimeter() {
		return circle.perimeter();
	}
	
	public double area() {
		return circle.area();
	}

	@Override
	public String toString() {
		return "CircleWithCentre [c=" + circle + ", p=" + center + "]";
	}

	public static boolean overlaps(CircleWithCentre c1, CircleWithCentre c2) {
	    double dis = new Point(0, 0).distance(c1.getCentre(), c2.getCentre());
	    return dis <= (c1.getRadius() + c2.getRadius());
	}



}

