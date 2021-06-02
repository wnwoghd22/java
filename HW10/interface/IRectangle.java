public class IRectangle implements IShape {
	private double width, height;

	IRectangle(double w, double h) { width = w; height = h; }

	public double calcArea() { return width * height; }
	public double calcPerimeter() { return 2 * ( width + height ); }
}