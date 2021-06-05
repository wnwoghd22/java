import java.util.*;

public class Main1 {
	public static double ranGen() {
		double result = Math.random() * 60 + 6;
		result = Math.ceil(result * 100) / 100;
		return result;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n, range, count = 0, temp;
		System.out.print("# of numbers : "); 
		while(true) {
	        temp = sc.nextInt();
	        if(temp > 0) break;
			System.out.print("# of numbers : "); 
		}
		n = temp;
		
		System.out.print("Range : ");
		while(true) {
		    temp = sc.nextInt();
		    if(temp % 10 == 0) break;
			System.out.print("Range : ");
		}
		range = temp / 10;

		double[] arr = new double[n];

		System.out.print("Random numbers : ");
		for(int i = 0; i < n; ++i) {
			arr[i] = ranGen();
			System.out.printf("%.1f ", arr[i]);
		}
		System.out.print("\nIntegers in [" + range * 10 + "," + (range + 1) * 10 + ") : ");
		for(int i = 0; i < n; ++i) {
			int tempInt = arr[i] - (int)arr[i] > 0.5 ? (int)Math.ceil(arr[i]) : (int)Math.floor(arr[i]);
			if(tempInt / 10 >= range && tempInt / 10 < range + 1) {
				count++;
				System.out.print(tempInt + " ");
			}
		}
		double perc = Math.ceil(((double)count / n) * 1000) / 1000;
		System.out.println("\n# in [" + range * 10 + "," + (range + 1) * 10 + ") : " + count);
		//System.out.println("% in [" + range * 10 + "," + (range + 1) * 10 + ") : " + perc);
		System.out.printf("%% in [%d,%d) : %.3f\n", range * 10, (range + 1) * 10, perc);
		
	}
}