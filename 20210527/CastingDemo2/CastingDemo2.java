public class CastingDemo2 {
	public static void main(String args[]) {
		display(new Circle(3.5));
		display(new Rectangle(4, 5));
		display(new Trapezoid(4, 5, 6));
		display(new Diamond(4, 5));
		display(new Ellipse(4, 5));
	}
	public static void display(ObjectH o) { System.out.println(o.getArea()); }
}

abstract class ObjectH {
	public abstract double getArea();
}
class Rectangle extends ObjectH {
	private double width, height;
	Rectangle(double w, double h) { width = w; height = h; }
	@Override
	public double getArea() { return width * height; }
}
class Trapezoid extends ObjectH {
	private double w1, w2, height;
	Trapezoid(double w1, double w2, double height) {
		this.w1 = w1; this.w2 = w2; this.height = height;
	}
	@Override
	public double getArea() { return height * (w1 + w2) / 2.0; }
}
class Diamond extends ObjectH {
	private double horizontal, vertical;
	Diamond(double h, double v) { horizontal = h; vertical = v; }
	@Override
	public double getArea() { return horizontal * vertical / 2.0; }
}
class Circle extends ObjectH {
	private double radius;
	Circle(double r) { radius = r; }
	@Override
	public double getArea() { return Math.PI * radius * radius; }
}
class Ellipse extends ObjectH {
	private double a, b;
	Ellipse(double a, double b) { this.a = a; this.b = b; }
	@Override
	public double getArea() { return Math.PI * a * b; }
}
