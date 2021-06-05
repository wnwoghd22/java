import java.util.*;
import java.io.*;

public class Level1 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("./Quad.txt"));

			List<Geo> list = new ArrayList<Geo>();
			
			String color = ""; int[] arr = new int[8]; int count = 0;
			while(sc.hasNextLine()) {
				for(int i = 0; i < 8; ++i) {
					arr[i] = sc.nextInt();
				} color = sc.next();

				if(Geo.isQuadrangle(arr)) {
					list.add(new Quadrangle(
						new int[] { arr[0], arr[2], arr[4], arr[6] },
						new int[] { arr[1], arr[3], arr[5], arr[7] },
						color
					));
				}
				if(++count == 20) break;
			}
			
			Geo[] geoArr = new Geo[list.size()];
			for(int i = 0; i < geoArr.length; ++i) geoArr[i] = list.get(i);

			Arrays.sort(geoArr);

			for(Geo g : geoArr) { g.print(); }

			FindSamePerimeter(geoArr);
			FindSameColor(geoArr);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void FindSameColor(Geo[] arr) {
		System.out.println("\n*Same Color : ");
		boolean visited[] = new boolean[arr.length];

		for(int i = 0; i < arr.length - 1; ++i) {
			if(visited[i]) continue;
			boolean flag = false; visited[i] = true;
			for(int j = i + 1; j < arr.length; ++j) {
				if(arr[i].getColor().equals(arr[j].getColor())) {
					if(!flag) {
						flag = true;
						System.out.println("Color : " + arr[i].getColor());
						arr[i].print();
					}
					arr[j].print();
					visited[j] = true;
				}
			}
		}
	}
	public static void FindSamePerimeter(Geo[] arr) {
		System.out.println("\n*Same Perimeter : ");
		boolean visited[] = new boolean[arr.length];

		for(int i = 0; i < arr.length - 1; ++i) {
			if(visited[i]) continue;
			boolean flag = false; visited[i] = true;
			for(int j = i + 1; j < arr.length; ++j) {
				if(arr[i].getPerimeter() == arr[j].getPerimeter()) {
					if(!flag) {
						flag = true;
						System.out.println("Perimeter : " + arr[i].getPerimeter());
						arr[i].print();
					}
					arr[j].print();
					visited[j] = true;
				}
			}
		}
	}
}