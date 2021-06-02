import java.util.Scanner;

class test3 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t;

        t = sc.nextInt();

        while(t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

            int sum = Math.abs(2 * b - a - c);

            //System.out.println(sum / 2 + sum % 2);
            System.out.println((sum >> 1) + (sum & 1));
        }
    }
}
