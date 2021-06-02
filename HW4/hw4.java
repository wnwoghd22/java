import java.util.Scanner;

public class hw4 {
	public static void main(String args[]) {
		int a, b;

		Scanner sc = new Scanner(System.in);
		System.out.print("input a : ");
		a = sc.nextInt();
		System.out.print("input b : ");
		b = sc.nextInt();

		final int big = a > b ? a : b, small = a > b ? b : a;

		System.out.println("");
		System.out.println("Product : " + big + " * " + small + " = " + (big * small));	
		System.out.println("Difference : " +big + " - " + small + " = " +  (big - small));	
		System.out.println("Quotient : " + big + " / " + small + " = " + (big / small));	
		System.out.println("Remainder : " + big + " % " + small + " = " + (big % small));	
	}
}