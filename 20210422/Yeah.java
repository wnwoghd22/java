

public class Yeah{
	public static void main(String args[]) {
		double[] arr1 = new double[10];
		double arr2[] = new double[10];
		for(int i = 0; i < 10; ++i) {
			arr1[i] = i; arr2[i] = i + 1;
		}
		System.out.println(arr1.length + " " + arr2.length);
	}
}