public abstract class Shape {
	private String name;

	public Shape() { name = "none"; }
	public Shape(String name) { this.name = name; }

	public String getName() { return name; }
	public void getName(String name) { this.name = name; }

	@Override
	public String toString() { return "This is " + name + "."; }

	public abstract String draw(int[] x, int[] y);
}