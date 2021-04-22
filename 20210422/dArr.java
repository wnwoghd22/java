

public class dArr{
	public static void main(String args[]) {
		double[] arr = new double[10];

		for(int i = 0; i < arr.length; ++i) {
			arr[i] = Math.random() * 100;
		}
		System.out.println("{ ");
		for(int i = 0; i < arr.length; ++i) System.out.println("\t" + arr[i] + ", ");
		System.out.println("}");

		double sum = 0.0;
		for(int i = 0; i < arr.length; ++i) sum += arr[i];

		double mean = Math.floor(sum / arr.length * 10) / 10;

		System.out.println(sum / arr.length + ", " + mean);

		double min = arr[0];
		for(int i = 1; i < arr.length; ++i) if(min > arr[i]) min = arr[i];
		System.out.println("min : " + min);	
	}
}