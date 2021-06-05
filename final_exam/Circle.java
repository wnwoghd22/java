public class Circle extends Geo {
	private int[] x;
	private int[] y;
	private double radius;

	public Circle(int[] x, int[] y, String color) {
		super(color, "Circle");

		this.x = x; this.y = y;

		radius = Geo.calcDis(x[0], y[0], x[1], y[1]) / 2.0;

		super.setPerimeter(getPerimeter());
	}

	

	@Override
	public double getPerimeter() {
		return Math.round(Math.PI * radius * 2 * 100) / 100.0;
	}
	@Override
	public String draw(int[] x, int[] y) {
		return "Drawing Circle here : (" 
			+ x[0] + ", " + y[0] + "), ("
			+ x[1] + ", " + y[1] + ") : " + getPerimeter();
	}
	@Override
	public String toString() { return super.toString() + "\n" + draw(x, y); }
	@Override
	public void print() { System.out.println(this.toString()); }

}