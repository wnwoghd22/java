#include <iostream>

int main() {
	int t;
	std::cin >> t;

	while (t--) {
		int a, b, c;
		std::cin >> a >> b >> c;

		int sum = abs(2 * b - a - c);

		std::cout << ((sum >> 1) + (sum & 1)) << std::endl;
	}

	return 0;
}