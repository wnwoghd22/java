import java.util.*;

class SignOfPlace1 {
    public static final long modNum = 1000000007;
    public static long SumMod(long[] arr, int l, int r) {
        long sum = 0;
        for(int i = l; i < r; ++i)
            sum = (sum + arr[i]) % modNum;
        return sum;
    }
    public static long[] Cumulate(long[] arr, char c) {
        long[] temp = new long[arr.length];
        for(int i = 0; i < arr.length; ++i)
            switch(c) {
            case '>' :
                temp[i] = SumMod(arr, i + 1, arr.length);
                break;
            case '<' :
                temp[i] = SumMod(arr, 0, i);
                break;
            case '=':
                temp[i] = arr[i];
                break;
            default:
                break;
            }
        //System.out.println(Arrays.toString(temp));
        return temp;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; ++i) arr[i] = 1;

        String s = sc.next();
        for(int i = 0; i < s.length(); ++i)
            arr = Cumulate(arr, s.charAt(i));

        long sum = 0;
        for(int i = 0; i < n; ++i)
            sum = (sum + arr[i]) % modNum;

        System.out.println(sum);
    }
}
