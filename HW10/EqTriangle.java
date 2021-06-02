public class EqTriangle extends GObject {
	private double width;

	public EqTriangle(double w) { width = w; }
	public EqTriangle(double w, String c) { super(c); width = w; }

	private double calcArea() { return Math.sqrt(3.0) / 4 * width * width; }
	private double calcPerimeter() { return 3 * width; }

	public void cStatePrint() {
		System.out.print("One equilateral triangle is");
		super.cStatePrint();
		System.out.printf("Its area is %.1f, its perimeter is %.1f\n", calcArea(), calcPerimeter());
	}
}