import java.util.*;

class Pairs {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        long len = sc.nextLong();

        long[] arr = new long[(int)len];

        for(int i = 0; i < (int)len; ++i) {
            arr[i] = sc.nextLong();
        }

        long result = 0;

        for(long i = 1; i <= len - 1; ++i) {
            long tempI = arr[(int)i - 1], sqI = i * i;
            for(long j = i + 1; j <= len; ++j) {
                long tempJ = arr[(int)j - 1], sqJ = j * j;
                if(Math.abs(tempJ - tempI) == sqI + sqJ)
                    ++result;
            }
        }

        System.out.print(result);
    }
}
