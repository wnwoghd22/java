public class Sum{
	public int sumAbs(int from, int to) {
		int result =0;
		for(int i = from; i <= to; ++i) {
			result += i < 0 ? -i : i;
		}
	
		return result;
	}

	private boolean isPrime(int n) {
		boolean result = true;
		if(n == 1) return result;
		for(int i = 2; i <= (int)Math.sqrt(n < 0 ? -n : n); ++i)
			if(n % i == 0) result = false;

		return result;
	}

	public int sumPrimes(int from, int to) {
		int result = 0;
		for(int i = from; i <= to; ++i) {
			if(isPrime(i))
				result += i < 0 ? -i : i;
		}
		return result;
	}

}