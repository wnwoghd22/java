

public class TestCircle {
	public static void main(String args[]){
		
		CircleWithRadiusException c1 = new CircleWithRadiusException(1);
		CircleWithRadiusException c2 = new CircleWithRadiusException(-1);
		CircleWithRadiusException c3 = new CircleWithRadiusException(101);

		System.out.println("# of Circles : " + CircleWithRadiusException.getNumberOfObjects());

	}

	private static void test1() {
		double[] arr = { 1, -1, 200 };

		for(int i = 0; i < arr.length; ++i) {
			
		}
	}
}

class CircleWithRadiusException {
	private double radius;
	private static int numberOfObjects = 0;
	public CircleWithRadiusException(double r) {
		try { 
			setRadius(r); 
			++numberOfObjects;
		}
		catch(InvalidRadiusException e) {
			System.out.println(e);
			radius = 1.0;
		}
	}
	public void setRadius(double r) throws InvalidRadiusException {
		if(r <= 0) throw new NegativeRadiusException(r);
		else if(r > 100) throw new OverRadiusException(r);
		else radius = r;
	}
	public static int getNumberOfObjects() { return numberOfObjects; }
}
class InvalidRadiusException extends Exception {
	public InvalidRadiusException(String s) {
		super(s);
	}
}
class OverRadiusException extends InvalidRadiusException {
	public OverRadiusException(double r) {
		super("Over radius! : " + r);
	}
}
class NegativeRadiusException extends InvalidRadiusException {
	public NegativeRadiusException(double r) {
		super("Negative radius! : " + r);
	}
}