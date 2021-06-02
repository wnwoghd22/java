public class ICircle implements IShape {
	private double radius;

	ICircle(double r) { radius = r; }

	public double calcArea() { return radius * radius * Math.PI; }
	public double calcPerimeter() { return 2 * radius * Math.PI; }
}