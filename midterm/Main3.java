import java.util.*;

public class Main3 {
	public static void Stars(int n) {
		for(int i = 1; i <= n; ++i) {
			for(int j = 0; j < i; ++j) System.out.print('*');
			System.out.println("");
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int temp = 1;
		do {
			temp = sc.nextInt();
			if (temp > 0) break;
			System.out.println("out of range!");
		}while(true);
		int n = temp;
		
		while(n > 0) {
			Stars(n--);
		}
	}
}