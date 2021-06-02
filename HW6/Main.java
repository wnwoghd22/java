import java.util.Scanner;

public class Main {
	static int n1 = 0, n2 = 0, n3 = 0, currentRow = 0;
	static void SetNum(int _n1, int _n2) { if(_n1 > _n2) { n1 = _n1; n2 = _n2; } else { n1 = _n2; n2 = _n1; } n3 = 10; }
	static int n() { return n1 - n2 + 1; }
	static int row() { return (n() - 1) / 3; }
 	static int remain() { return currentRow == row() ? ( n() % 3 == 0 ? 3 : n() % 3 ) : 3 ; }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SetNum(sc.nextInt(), sc.nextInt());

		for(currentRow = 0; currentRow < row() + 1; ++currentRow) {
			for(int i = 1; i < n3; ++i) {
				for(int j = 0; j < remain(); ++j)
					System.out.printf("%2d * %2d = %-10d", (currentRow * 3 + j + n2), i, (currentRow * 3 + j + n2) * i);
				System.out.println("");
			}
			System.out.println("");
		}
	}
}