import java.util.*;

public class Main2 {
	public static Random random;
	public static double Rand() {
		return random.nextDouble() * 2 - 1;
	}
	public static boolean Sample(double x, double y, double z) {
		return Math.sqrt(x*x + y*y + z*z) < 1 ? true : false;
	}
	public static double simulate(int n_a) {
		int n_s = 0;
		for(int i = 0; i < n_a; ++i)
			if(Sample(Rand(), Rand(), Rand()))
				++n_s;

		return  6.0 * n_s / n_a;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		random = new Random();

		System.out.print("How many samples to generate? ");
		int na = sc.nextInt();
		double result = simulate(na);

		System.out.println("pi from " + na + " samples = " + result + ", error = " + (Math.PI - result));
	}
}