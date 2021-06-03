import java.util.*;

public class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Sum s = new Sum();

		int from = sc.nextInt(), to = sc.nextInt();

		System.out.println("sumAbs(" + from + ", " + to + ") : " + s.sumAbs(from, to));
		System.out.println("sumPrime(" + from + ", " + to + ") : " + s.sumPrimes(from, to));
	}


}