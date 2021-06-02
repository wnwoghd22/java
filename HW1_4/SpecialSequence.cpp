#include <iostream>
#include <cmath>
#define MAX 500000

long long int Occur(long long int i) {
	return i * (int)sqrt(i) + ceil(i / 2.0);
}

int binarySearch(long long int* arr, int l, int r, long long int x) {
    if (r >= l) {
        int mid = l + (r - l) / 2;
 
        if (arr[mid] == x)
            return mid;
 
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);
 
        return binarySearch(arr, mid + 1, r, x);
    }

    return arr[l] >= x ? l : l - 1;
}
 

int main() {
	long long int sum = 0;
	long long int* arr = new long long int[MAX];
	for(int i = 0; i < MAX; ++i) {
		sum += Occur(i);
		arr[i] = sum;
	}

	long long int q, l, r;

	std::cin >> q;

	while(q--) {
		std::cin >> l >> r;

		int rIdx = binarySearch(arr, 0, 500000, r);
		int lIdx = binarySearch(arr, 0, 500000, l);

		std::cout << rIdx - lIdx + 1 << std::endl;
	}

	return 0;
}
