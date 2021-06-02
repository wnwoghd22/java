#include <iostream>

class Table {
private:
	bool** table;
	int r; int c;
	int MaxRow() {
		bool upperFlag = false;
		int tempUpper = 0;
		int upperBorder = 0;
		bool underFlag = false;
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
	int MaxCol() {
		bool leftFlag = false;
		int tempLeft = 0;
		int leftBorder = 0;
		bool rightFlag = false;
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

public:
	Table(char** t, int _r, int _c) {
		r = _r; c = _c;
		table = new bool* [r + 2];
		for (int i = 0; i < r + 2; ++i)
			table[i] = new bool[c + 2];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				table[i + 1][j + 1] = t[i][j] == '#' ? true : false;
			}
		}
	}
	int MaxBorder() {
		return MaxCol() > MaxRow() ? MaxCol() : MaxRow();
	}
};

int main(void) {
	int t;
	int r, c;

	std::cin >> t;

	while (t--) {
		std::cin >> r >> c;

		char** t = new char*[r];

		for (int i = 0; i < r; ++i) {
			t[i] = new char[c];

			for (int j = 0; j < c; ++j) {
				std::cin >> t[i][j];
			}
		}

		std::cout << Table(t, r, c).MaxBorder() << std::endl;
	}

	return 0;
}