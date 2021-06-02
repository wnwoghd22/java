public class Rectangle implements Drawable {
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	Rectangle(double x1, double y1, double x2, double y2) {
		this.x1 = x1; this.x2 = x2; this.y1 = y1; this.y2 = y2;
	}
	public void draw(int color) {
		System.out.printf("Rectangle drawn with upper-left corner at (%.1f, %.1f) and lower-right corner at (%.1f, %.1f), and color %d\n", x1, y1, x2, y2, color);
	}
	public double getX1() { return x1; }
	public double getX2() { return x2; }
	public double gety1() { return y1; }
	public double gety2() { return y2; }
}