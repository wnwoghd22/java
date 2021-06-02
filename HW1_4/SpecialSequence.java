import java.util.*;

public class SpecialSequence {
   public static long Occur(int n) {
        return (long)n * (long)Math.sqrt(n) + (long)Math.ceil(n / 2.0);
    }
    
    public static int binarySearch(long[] arr, int l, int r, long x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            //System.out.println(mid + " " + arr[mid] + " " + x);
    
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            else return binarySearch(arr, mid + 1, r, x);
        }

        return arr[l] >= x ? l : l - 1;
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Long> arrlist = new ArrayList<Long>();

        long sum = 0; int i = 1;
        while(sum < Math.pow(10, 13)) {
            sum += Occur(i++);
            arrlist.add(sum);
        }

        long[] arr = new long[arrlist.size()];
        for(i = 0; i < arr.length; ++i) arr[i] = arrlist.get(i);


        int q = sc.nextInt();
        long l, r;
        while(q-- > 0) {
            l = sc.nextLong(); r = sc.nextLong();

            //int indexL = Collections.binarySearch(arrlist, l);
            //int indexR = Collections.binarySearch(arrlist, r);
            
            int indexL = binarySearch(arr, 0, arr.length, l);
            int indexR = binarySearch(arr, 0, arr.length, r);

            indexL = indexL < 0 ? -indexL - 1 : indexL;
            indexR = indexR < 0 ? -indexR - 1 : indexR;
            
            System.out.println(indexR - indexL + 1);
        }
    }
}
