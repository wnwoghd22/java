import java.util.Scanner;
import java.io.*;

public class CSVconverter {
	public static void main(String args[]) {
		try{
			String f_name = args[0];
			String[] nameArr = f_name.split("\\.");
			System.out.print("Convert " + f_name + " to " + nameArr[0] + ".csv\n");

			File inF = new File(f_name);
			Scanner sc = new Scanner(inF);

			File outF = new File(nameArr[0] + ".csv");
			FileWriter w = new FileWriter(outF);

			int index = 0;
			while(sc.hasNextLine()) {
				String temp = sc.nextLine();
				String conv = "";

				String[] arr = temp.split("\t");

				for(int i = 0; i < arr.length; ++i) {
					conv += arr[i];
					conv += i != arr.length - 1 ? "," : "\n";
				}

				System.out.print((++index) + " : "+ temp + " -> " + conv);
				w.write(conv);
			}

			sc.close();
			w.close();

		} catch(Exception e) {
			System.out.print(e);
		}
	}
}