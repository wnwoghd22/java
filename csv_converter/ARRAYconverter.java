import java.util.Scanner;
import java.io.*;

public class ARRAYconverter {
	public static void main(String args[]) {
		try{
			String f_name = args[0];
			String[] nameArr = f_name.split("\\.");
			System.out.print("Convert " + f_name + " to " + nameArr[0] + ".c\n");

			File inF = new File(f_name);
			Scanner sc = new Scanner(inF);

			File outF = new File(nameArr[0] + ".c");
			FileWriter w = new FileWriter(outF);

			int index = 0;
			w.write("{ ");
			while(sc.hasNextLine()) {
				++index;
				String temp = sc.nextLine();

				String[] arr = temp.split("\t");
				for(int i = 0; i < arr.length; ++i)
					System.out.print(arr[i] + " ");
				if(arr.length > 1) {
					w.write("\"" + arr[1] + "\", ");
					if(index == 10) {
						index = 0;
						w.write("\n");
					}
				}
			}
			w.write(" }");

			sc.close();
			w.close();

		} catch(Exception e) {
			System.out.print(e);
		}
	}
}