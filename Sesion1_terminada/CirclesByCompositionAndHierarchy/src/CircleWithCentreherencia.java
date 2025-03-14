
public class CircleWithCentreherencia extends Circle {
	private Point centre;
	public CircleWithCentreherencia (int x, int y, double radius) {
		super(radius);
		setCentre(new Point (x, y));
	}
}
