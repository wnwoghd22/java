import java.util.*;
import java.io.*;

public class Level2 {
	public static void main(String[] args) {
		if(args.length != 2) return;

		try {
			String input = args[0], output = args[1];
			Scanner sc = new Scanner(new File(input));
			FileWriter fw = new FileWriter(new File(output));

			List<Geo> list = new ArrayList<Geo>();
			
			//String color = ""; int[] arr = new int[8];
			String line = ""; int count = 0;

			while(sc.hasNextLine()) {
				line = sc.nextLine();
				String[] sp = line.split(" ");

				switch(sp.length) {
				case 5 : //circle	
					int[] cArr = {
						Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), 
						Integer.parseInt(sp[2]), Integer.parseInt(sp[3])
					};
					if(Geo.isCircle(cArr)) {
						list.add(new Circle(
							new int[] { cArr[0], cArr[2] },
							new int[] { cArr[1], cArr[3] },
							sp[4]
						));
					} else fw.write("(" + cArr[0] + ", " + cArr[1] + "), (" + cArr[2] + ", " + cArr[3] + ") is not a circle.\n");
					break;
				case 7 : //triangle
					int[] tArr = {
						Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), 
						Integer.parseInt(sp[2]), Integer.parseInt(sp[3]),
						Integer.parseInt(sp[4]), Integer.parseInt(sp[5])
					};
					if(Geo.isTriangle(tArr)) {
						list.add(new Triangle(
							new int[] { tArr[0], tArr[2], tArr[4] },
							new int[] { tArr[1], tArr[3], tArr[5] },
							sp[6]
						));
					} else fw.write("(" + tArr[0] + ", " + tArr[1] + "), (" + tArr[2] + ", " + tArr[3] + "), ("+ tArr[4] + ", " + tArr[5] + ") is not a triangle.\n");
					break;
				case 9 : //quadrangle
					int[] qArr = {
						Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), 
						Integer.parseInt(sp[2]), Integer.parseInt(sp[3]),
						Integer.parseInt(sp[4]), Integer.parseInt(sp[5]),
						Integer.parseInt(sp[6]), Integer.parseInt(sp[7])
					};
					if(Geo.isQuadrangle(qArr)) {
						list.add(new Quadrangle(
							new int[] { qArr[0], qArr[2], qArr[4], qArr[6] },
							new int[] { qArr[1], qArr[3], qArr[5], qArr[7] },
							sp[8]
						));
					} else fw.write("(" + qArr[0] + ", " + qArr[1] + "), (" + qArr[2] + ", " + qArr[3] + "), ("+ qArr[4] + ", " + qArr[5] + "), ("+ qArr[6] + ", " + qArr[7] + ") is not a quadrangle.\n");
					break;
				}
				
				if(++count == 20) break;
			}
			fw.write("\n");
			
			Geo[] geoArr = new Geo[list.size()];
			for(int i = 0; i < geoArr.length; ++i) geoArr[i] = list.get(i);

			Arrays.sort(geoArr);

			for(Geo g : geoArr) { fw.write(g + "\n"); }

			fw.flush();
			fw.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}