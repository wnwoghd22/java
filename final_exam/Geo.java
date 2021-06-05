public abstract class Geo extends Shape implements Comparable<Geo> {
	public static final double error = 0.0001;
	private String color;
	private double perimeter;

	public Geo() {
		super();
		color = "white";
		perimeter = 0;
	}
	public Geo(String name) {
		super(name);
		color = "white";
		perimeter = 0;
	}
	public Geo(String c, String n) {
		super(n);
		color = c;
	}

	@Override
	public int compareTo(Geo o) {
		if(getPerimeter() - o.getPerimeter() > error) return 1;
		else if(getPerimeter() - o.getPerimeter() < error) return -1;
		else return 0;
	}
	public abstract double getPerimeter();

	public static double calcDis(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	public static boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1);
	}

	public static boolean isQuadrangle(int[] arr) {
		return (
			calcDis(arr[0], arr[1], arr[2], arr[3]) > error &&
			calcDis(arr[0], arr[1], arr[4], arr[5]) > error &&
			calcDis(arr[0], arr[1], arr[6], arr[7]) > error &&
			calcDis(arr[2], arr[3], arr[4], arr[5]) > error &&
			calcDis(arr[2], arr[3], arr[6], arr[7]) > error &&
			calcDis(arr[4], arr[5], arr[6], arr[7]) > error &&
			!isLine(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]) &&
			!isLine(arr[0], arr[1], arr[2], arr[3], arr[6], arr[7]) &&
			!isLine(arr[0], arr[1], arr[4], arr[5], arr[6], arr[7]) &&
			!isLine(arr[2], arr[3], arr[4], arr[5], arr[6], arr[7])
		);
	}
	public static boolean isTriangle(int[] arr) {
		return (
			calcDis(arr[0], arr[1], arr[2], arr[3]) > error &&
			calcDis(arr[0], arr[1], arr[4], arr[5]) > error &&
			calcDis(arr[2], arr[3], arr[4], arr[5]) > error &&
			!isLine(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5])
		);
	}
	public static boolean isCircle(int[] arr) {
		return calcDis(arr[0], arr[1], arr[2], arr[3]) > error;
	}
	public void setPerimeter(double p) { perimeter = p; }

	@Override
	public String toString() { return super.toString() + " The color is " + color + "."; }

	public abstract void print();

	public String getColor() { return color; }
	
	public static boolean isQuadrangleC(int[] arr) throws GeometricException {
		if(
			calcDis(arr[0], arr[1], arr[2], arr[3]) < error ||
			calcDis(arr[0], arr[1], arr[4], arr[5]) < error ||
			calcDis(arr[0], arr[1], arr[6], arr[7]) < error ||
			calcDis(arr[2], arr[3], arr[4], arr[5]) < error ||
			calcDis(arr[2], arr[3], arr[6], arr[7]) < error ||
			calcDis(arr[4], arr[5], arr[6], arr[7]) < error
		) throw new SamePointException();
		else if (
			isLine(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]) ||
			isLine(arr[0], arr[1], arr[2], arr[3], arr[6], arr[7]) ||
			isLine(arr[0], arr[1], arr[4], arr[5], arr[6], arr[7]) ||
			isLine(arr[2], arr[3], arr[4], arr[5], arr[6], arr[7])
		) throw new OnlineException();
		else return true;
	}
	public static boolean isTriangleC(int[] arr) throws GeometricException {
		if (
			calcDis(arr[0], arr[1], arr[2], arr[3]) < error ||
			calcDis(arr[0], arr[1], arr[4], arr[5]) < error ||
			calcDis(arr[2], arr[3], arr[4], arr[5]) < error
		) throw new SamePointException();
		else if( isLine(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]) )
			throw new OnlineException();
		else return true;
		
	}
	public static boolean isCircleC(int[] arr) throws GeometricException {
		if (calcDis(arr[0], arr[1], arr[2], arr[3]) < error) throw new SamePointException();
		else return true;
	}
}