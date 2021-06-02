import java.lang.*;
import java.util.*;

public class TestGeo {
	private static boolean isRectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		return ( 
			!Geo.checkLength(x1, y1, x2, y2) &&
			!Geo.checkLength(x1, y1, x3, y3) &&
			!Geo.checkLength(x1, y1, x4, y4) &&
			!Geo.checkLength(x2, y2, x3, y3) &&
			!Geo.checkLength(x2, y2, x4, y4) &&
			!Geo.checkLength(x3, y3, x4, y4) &&
			!Geo.checkLine(x1, y1, x2, y2, x3, y3) &&
			!Geo.checkLine(x1, y1, x2, y2, x4, y4) &&
			!Geo.checkLine(x1, y1, x3, y3, x4, y4) &&
			!Geo.checkLine(x2, y2, x3, y3, x4, y4)
		);
	}
	private static boolean isTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		return ( 
			!Geo.checkLength(x1, y1, x2, y2) &&
			!Geo.checkLength(x1, y1, x3, y3) &&
			!Geo.checkLength(x2, y2, x3, y3) &&
			!Geo.checkLine(x1, y1, x2, y2, x3, y3)
		);
	}
	private static boolean isCircle(int x1, int y1, int x2, int y2) {
		return (!Geo.checkLength(x1, y1, x2, y2));
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		List<Geo> list = new ArrayList<Geo>();
		boolean flag = false;

		for(int i = 0; i < 10; ++i) {
			System.out.print("Points (x1 y1 x2 y2 x3 y3 ...) : ");
			String line = sc.nextLine();
			String[] argsS = line.split(" ");
			switch(argsS.length) {
			case 4 : //circle
				int c_x1 = Integer.parseInt(argsS[0]), c_y1 = Integer.parseInt(argsS[1]),
				c_x2 = Integer.parseInt(argsS[2]), c_y2 = Integer.parseInt(argsS[3]);
				if(isCircle(c_x1, c_y1, c_x2, c_y2))
					list.add(new Circle(c_x1, c_y1, c_x2, c_y2));
				else System.out.println("This is not Circle.");
				break;
			case 8 : //Rectangle
				int r_x1 = Integer.parseInt(argsS[0]), r_y1 = Integer.parseInt(argsS[1]),
				r_x2 = Integer.parseInt(argsS[2]), r_y2 = Integer.parseInt(argsS[3]),
				r_x3 = Integer.parseInt(argsS[4]), r_y3 = Integer.parseInt(argsS[5]),
				r_x4 = Integer.parseInt(argsS[6]), r_y4 = Integer.parseInt(argsS[7]);
				if(isRectangle(r_x1, r_y1, r_x2, r_y2, r_x3, r_y3, r_x4, r_y4))
					list.add(new Rectangle(r_x1, r_y1, r_x2, r_y2, r_x3, r_y3, r_x4, r_y4));
				else System.out.println("This is not Rectangle.");
				break;
			case 6 : //Triangle
				int t_x1 = Integer.parseInt(argsS[0]), t_y1 = Integer.parseInt(argsS[1]),
				t_x2 = Integer.parseInt(argsS[2]), t_y2 = Integer.parseInt(argsS[3]),
				t_x3 = Integer.parseInt(argsS[4]), t_y3 = Integer.parseInt(argsS[5]);
				if(isTriangle(t_x1, t_y1, t_x2, t_y2, t_x3, t_y3))
					list.add(new Triangle(t_x1, t_y1, t_x2, t_y2, t_x3, t_y3));
				else System.out.println("This is not Triangle.");
				break;
			default :
				flag = true;
			}
			if(flag) break;
		} System.out.println("The end of input!");

		System.out.println("Sorting geometries according ot their longest length.");

		Geo[] geoArr = list.toArray(new Geo[list.size()]);
		Arrays.sort(geoArr);
		for(int i = 0; i < geoArr.length; ++i) {
			System.out.println(geoArr[i]);
		}
	}
}
abstract class Geo implements Comparable<Geo> {
	double longest;
	static final double error = 0.0001;

	Geo(double longest) {
		this.longest = Math.round(longest * 1000) / 1000.0;
	}
	Geo() { longest = 0;  }

	@Override
	public int compareTo(Geo o) {
		if (Math.abs(longest - o.longest) < error) return 0;
		else if (longest > o.longest) return 1;
		else return -1;
	}

	public static double calcLength(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	public static boolean checkLine(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1);
	}
	public static boolean checkLength(int x1, int y1, int x2, int y2) {
		return calcLength(x1, y1, x2, y2) < error;
	}
	protected static double findLongest(double[] len) {
		Arrays.sort(len);
		return len[len.length - 1];
	}
}

class Rectangle extends Geo {
	int[] x, y;

	Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		
		super(findLongest(new double[] {
			calcLength(x1, y1, x2, y2),
			calcLength(x1, y1, x3, y3),
			calcLength(x1, y1, x4, y4),
			calcLength(x2, y2, x3, y3),
			calcLength(x2, y2, x4, y4),
			calcLength(x3, y3, x4, y4)	
		}));
		x = new int[] { x1, x2, x3, x4 };
		y = new int[] { y1, y2, y3, y4 };

		System.out.println("Rectangle. The longest length is " + longest + ".");	
	}

	@Override
	public String toString() {
		String result = "Rectangle((";
		for(int i = 0; i < 4; ++i) result += x[i] + ", " + y[i] + ")," + (i != 3 ? "(" : longest + ")");
		
		return result;				
	}
}
class Triangle extends Geo {
	int[] x, y;

	Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		
		super(findLongest(new double[] {
			calcLength(x1, y1, x2, y2),
			calcLength(x1, y1, x3, y3),
			calcLength(x2, y2, x3, y3)
		}));
		x = new int[] { x1, x2, x3 };
		y = new int[] { y1, y2, y3 };

		System.out.println("Triangle. The longest length is " + longest + ".");		
	}

	@Override
	public String toString() {
		String result = "Triangle((";
		for(int i = 0; i < 3; ++i) result += x[i] + ", " + y[i] + ")," + (i != 2 ? "(" : longest + ")");
		
		return result;				
	}
}
class Circle extends Geo {
	int[] x, y;
	
	Circle(int x1, int y1, int x2, int y2) {
		super(calcLength(x1, y1, x2, y2));

		x = new int[] { x1, x2 };
		y = new int[] { y1, y2 };

		System.out.println("Circle. The longest length is " + longest + ".");	
	}
	@Override
	public String toString() {
		String result = "Circle((";
		for(int i = 0; i < 2; ++i) result += x[i] + ", " + y[i] + ")," + (i != 1 ? "(" : longest + ")");
		
		return result;
	}
	public double getRadius() { return longest / 2; }
}
