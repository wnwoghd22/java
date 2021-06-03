import java.io.*;
import java.util.*;

public class FindStatistics {
	public static void main(String args[]) {
		Scanner sc = null;

		try {
			sc = new Scanner(new File(args[0]));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		int len = sc.nextInt(), sum = 0, maximum, minimum;
		double average;
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			System.out.print(arr[i] + " ");
		}

		Arrays.sort(arr);
		maximum = arr[0]; minimum = arr[len - 1];
		average = (double)sum / len;		

		try (FileWriter writer = new FileWriter(new File(args[1]))) {
			System.out.println("Print");
			writer.write("Sum = " + sum + "\n");
			writer.write("Average = " + average + "\n");
			writer.write("Maximum = " + maximum + "\n");
			writer.write("Minimum = " + minimum + "\n");
			writer.write("Sorted\n");
			for(int i = len - 1; i >= 0; --i) writer.write(arr[i] + " ");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}