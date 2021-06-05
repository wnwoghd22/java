public class Triangle extends Geo {
	private int[] x;
	private int[] y;

	public Triangle(int[] x, int[] y, String color) {
		super(color, "Triangle");

		this.x = x; this.y = y;

		super.setPerimeter(getPerimeter());
	} 

	@Override
	public double getPerimeter() {
		double p1 = Geo.calcDis(x[0], y[0], x[1], y[1]);
		double p2 = Geo.calcDis(x[1], y[1], x[2], y[2]);
		double p3 = Geo.calcDis(x[2], y[2], x[0], y[0]);

		return Math.round((p1 + p2 + p3) * 100) / 100.0;
	}
	@Override
	public String draw(int[] x, int[] y) {
		return "Drawing Triangle here : (" 
			+ x[0] + ", " + y[0] + "), ("
			+ x[1] + ", " + y[1] + "), ("
			+ x[2] + ", " + y[2] + ") : " + getPerimeter();
	}
	@Override
	public String toString() { return super.toString() + "\n" + draw(x, y); }
	@Override
	public void print() { System.out.println(this.toString()); }

}