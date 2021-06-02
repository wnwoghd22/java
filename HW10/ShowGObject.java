import java.util.*;

public class ShowGObject{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int input;
		while(true) {
			System.out.print("Shape ? 1. Equilateral Triangle / 2. Rectangle / 3. Circle / 4. Quit : ");
			input = sc.nextInt();
			GObject g = null; String c;

			switch(input) {
			case 1 : //EqTri
				System.out.print("Width : ");
				double w = sc.nextDouble();
				System.out.print("Color : ");
				c = sc.next();
				g = new EqTriangle(w, c);
				break;
			case 2 : //Rect
				System.out.print("Width : ");
				double wR = sc.nextDouble();
				System.out.print("Height : ");
				double hR = sc.nextDouble();
				System.out.print("Color : ");
				c = sc.next();
				g = new Rectangle(wR, hR, c);
				break;
			case 3 : // Circle
				System.out.print("Radius : ");
				double r = sc.nextDouble();
				System.out.print("Color : ");
				c = sc.next();
				g = new Circle(r, c);
				break;
			default :
				break;
			}

			if(input == 4) break;

			if(g != null) g.cStatePrint();
		}
	}
}