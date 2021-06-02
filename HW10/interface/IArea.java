import java.util.*;

public class IArea{
	private static void PrintShapeInfo(IShape s) {
		System.out.printf("Area : %.1f\n", s.calcArea());
		System.out.printf("Perimeter : %.1f\n", s.calcPerimeter());

	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int input;
		while(true) {
			System.out.print("Shape ? 1. Equilateral Triangle / 2. Rectangle / 3. Circle / 4. Quit : ");
			input = sc.nextInt();
			IShape s = null;

			switch(input) {
			case 1 : //EqTri
				System.out.print("Width : ");
				double w = sc.nextDouble();
				s = new IEqTriangle(w);
				break;
			case 2 : //Rect
				System.out.print("Width : ");
				double wR = sc.nextDouble();
				System.out.print("Height : ");
				double hR = sc.nextDouble();
				s = new IRectangle(wR, hR);
				break;
			case 3 : // Circle
				System.out.print("Radius : ");
				double r = sc.nextDouble();
				s = new ICircle(r);
				break;
			default :
				break;
			}

			if(input == 4) break;

			if(s != null) PrintShapeInfo(s);
		}

	}
}