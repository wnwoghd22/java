import java.util.*;

class SignOfPlace2 {
    public static final long modNum = 1000000007;
    public static long[] Cumulate(long[] arr, char c) {
        long[] temp = new long[arr.length];
        switch(c) {
        case '>' :
            for(int i = 1; i < arr.length - 1; ++i)
                temp[i] = (arr[i - 1] + temp[i - 1]) % modNum;
            break;
        case '<' :
            for(int i = arr.length - 2; i > 0; --i)
                temp[i] = (arr[i + 1] + temp[i + 1]) % modNum;
            break;
        case '=':
            for(int i = 1; i < arr.length - 1; ++i)
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
        long[] arr = new long[n + 2];
        for(int i = 1; i < n + 1; ++i) arr[i] = 1;
        arr[0] = 0; arr[n + 1] = 0;

        String s = sc.next();
        for(int i = 0; i < s.length(); ++i)
            arr = Cumulate(arr, s.charAt(i));

        long sum = 0;
        for(int i = 1; i < n + 1; ++i)
            sum = (sum + arr[i]) % modNum;

        System.out.println(sum);
    }
}
