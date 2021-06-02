public class Circle implements Drawable {
	private double x;
	private double y;
	private double radius;
	Circle(double x, double y, double radius) {
		this.x = x; this.y = y; this.radius = radius;
	}
	public void draw(int color) {
		System.out.printf("Circle drawn at (%.1f, %.1f), with radius %.1f and color %d\n", x, y, radius, color);
	}
	public double getRadius() { return radius; }
	public double getX() { return x; }
	public double getY() { return y; }
}