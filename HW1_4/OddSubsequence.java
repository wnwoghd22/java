import java.util.*;
import java.math.*;

class OddSubsequence {
    public static boolean debug;
    public static int modNum = 1000000007;

    public static long Combination(int n, int r) {
        BigInteger result = new BigInteger("1");
        if(r >= 0 && r <= n) {
            for(int i = n; i > n - r; --i) {
                result = result.multiply(new BigInteger(Integer.toString(i)));
	if(debug) System.out.println(result);
        }
            for(int i = 1; i <= r; ++i) {
                result = result.divide(new BigInteger(Integer.toString(i)));
	if(debug) System.out.println(result);
}
        }
        else
            result = new BigInteger("0");

        result = result.remainder(new BigInteger(Integer.toString(modNum)));
        
        return result.longValue();
    }
   
    public static void main(String args[] ) throws Exception {
        debug = false;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n, k;

        while(t-- > 0) {   
            n = sc.nextInt(); k = sc.nextInt();

            int even = 0, odd = 0;
            for(int i = 0; i < n; ++i)
                if(sc.nextInt() % 2 == 0) ++even; else ++odd;

            if(debug) System.out.println(even + " " + odd);

            long result = 0;

            /*only important thing is that : 
            choose 2k - 1 of odd numbers && choose any number of even numbers;
            */
            for(int i = 1; i <= k; i += 2) {
                result = (result + Combination(odd, i) * Combination(even, k - i)) % modNum;
            }

            System.out.println(result);
        }
    }
}
