import java.util.Scanner;

public class Border {
	public static int MaxRow(boolean[][] table, int r, int c) {
		boolean upperFlag = false;
		int tempUpper = 0;
		int upperBorder = 0;
		boolean underFlag = false;
		int tempUnder = 0;
		int underBorder = 0;

		//first line
		for (int j = 0; j < r + 2; ++j) {
			if (table[j][1] == true) {
				underFlag = true;
				++tempUnder;
			}
			else {
				underFlag = false;
				if (tempUnder > underBorder) {
					underBorder = tempUnder;
				}
				tempUnder = 0;
			}
		}

		for (int i = 1; i < c + 1; ++i) {
			for (int j = 0; j < r + 2; ++j) {
				if (table[j][i - 1] == true && table[j][i] == false) {
					upperFlag = true;
					++tempUpper;
				}
				else {
					upperFlag = false;
					if (tempUpper > upperBorder) {
						upperBorder = tempUpper;
					}
					tempUpper = 0;
				}
				if (table[j][i + 1] == true && table[j][i] == false) {
					underFlag = true;
					++tempUnder;
				}
				else {
					underFlag = false;
					if (tempUnder > underBorder) {
						underBorder = tempUnder;
					}
					tempUnder = 0;
				}
			}
		}

		//last line
		for (int j = 0; j < r + 2; ++j) {
			if (table[j][c + 1] == true) {
				upperFlag = true;
				++tempUpper;
			}
			else {
				upperFlag = false;
				if (tempUpper > upperBorder) {
					upperBorder = tempUpper;
				}
				tempUpper = 0;
			}
		}

		return upperBorder > underBorder ? upperBorder : underBorder;
	}
	public static int MaxCol(boolean[][] table, int r, int c) {
		boolean leftFlag = false;
		int tempLeft = 0;
		int leftBorder = 0;
		boolean rightFlag = false;
		int tempRight = 0;
		int rightBorder = 0;

		//first line
		for (int j = 0; j < c + 2; ++j) {
			if (table[1][j] == true) {
				rightFlag = true;
				++tempRight;
			}
			else {
				rightFlag = false;
				if (tempRight > rightBorder) {
					rightBorder = tempRight;
				}
				tempRight = 0;
			}
		}

		for (int i = 1; i < r + 1; ++i) {
			for (int j = 0; j < c + 2; ++j) {
				if (table[i - 1][j] == true && table[i][j] == false) {
					leftFlag = true;
					++tempLeft;
				}
				else {
					leftFlag = false;
					if (tempLeft > leftBorder) {
						leftBorder = tempLeft;
					}
					tempLeft = 0;
				}
				if (table[i + 1][j] == true && table[i][j] == false) {
					rightFlag = true;
					++tempRight;
				}
				else {
					rightFlag = false;
					if (tempRight > rightBorder) {
						rightBorder = tempRight;
					}
					tempRight = 0;
				}
			}
		}

		//last line
		for (int j = 0; j < c + 2; ++j) {
			if (table[r + 1][j] == true) {
				leftFlag = true;
				++tempLeft;
			}
			else {
				leftFlag = false;
				if (tempLeft > leftBorder) {
					leftBorder = tempLeft;
				}
				tempLeft = 0;
			}
		}

		return leftBorder > rightBorder ? leftBorder : rightBorder;
	}
	public static int MaxBorder(boolean[][] table, int r, int c) {
		int mCol = MaxCol(table, r, c), mRow = MaxRow(table, r, c);
		return mCol > mRow ? mCol : mRow;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t, r, c;
		t = sc.nextInt();
		while(t-- > 0) {
			r = sc.nextInt(); c = sc.nextInt();
			boolean[][] table = new boolean[r + 2][c + 2];
			for(int i = 0; i < r; ++i) {
				String s = sc.next();
				System.out.print(s);
				for(int j = 0; j < c; ++j) {
					char temp = s.charAt(j);
					if(temp == '#') table[i + 1][j + 1] = true;
				}
			}
			System.out.println(MaxBorder(table, r, c));
		}
	}
}