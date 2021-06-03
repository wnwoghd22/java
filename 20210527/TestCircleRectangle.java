import java.util.*;

//import geometric.*;
import geometric.GeometricObject;
import geometric.Rectangle;
import geometric.Circle;

public class TestCircleRectangle {
	public static void main(String args[]) {
		GeometricObject[] list = {
			new Rectangle(),
			new Rectangle(2.0, 3.5),
			new Rectangle(1.7, 4.2, "blue", true),
			new Circle(),
			new Circle(3.7),
			new Circle(5.3, "Yellow", true)
		};		

		for(int i = 0; i < list.length; ++i)
			//System.out.println(list[i].toString());
			list[i].print();
	}
}