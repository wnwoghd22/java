public class Rectangle extends GObject {
	private double width, height;

	public Rectangle(double w, double h) { width = w; height = h; }
	public Rectangle(double w, double h, String c) { super(c); width = w; height = h; }

	private double calcArea() { return width * height; }
	private double calcPerimeter() { return 2 * ( width + height ); }

	public void cStatePrint() {
		System.out.print("One rectangle is");
		super.cStatePrint();
		System.out.printf("Its area is %.1f, its perimeter is %.1f\n", calcArea(), calcPerimeter());
	}
}