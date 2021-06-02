import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t;

        t = sc.nextInt();

        boolean flag;

        while(t-- > 0) {
            flag = false;
            int len = sc.nextInt();
            int vc = 0;

            String s = sc.next();

            for(int i = 0; i < len; ++i) {
                char temp = s.charAt(i);
                switch(temp) {
                    case 'a' : case 'e' : case 'i' :
                    case 'o' : case 'u' :
                        if(flag)
                            ++vc;
                        flag = false;
                        break;
                    default :
                        flag = true;
                }
            }
            System.out.println(vc);
        }
    }
}
