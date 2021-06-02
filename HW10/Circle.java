public class Circle extends GObject {
	private double radius;

	public Circle(double r) { radius = r; }
	public Circle(double r, String c) { super(c); radius = r; }

	private double calcArea() { return radius * radius * Math.PI; }
	private double calcPerimeter() { return 2 * radius * Math.PI; }

	public void cStatePrint() {
		System.out.print("One circle is");
		super.cStatePrint();
		System.out.printf("Its area is %.1f, its perimeter is %.1f\n", calcArea(), calcPerimeter());
	}
}