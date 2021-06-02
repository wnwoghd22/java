public class IEqTriangle implements IShape {
	private double width;

	IEqTriangle(double w) { width = w; }

	public double calcArea() { return Math.sqrt(3.0) / 4 * width * width; }
	public double calcPerimeter() { return 3 * width; }
}