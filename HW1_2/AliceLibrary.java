import java.util.Scanner;

class AliceLibrary {
    public static String Reverse(String s) {
        int pre = 0, fin = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == '/') pre = i;
            if(c == '\\') { fin = i; break; }
        }
        String s1 = s.substring(0, pre);
        String s2 = s.substring(pre + 1, fin);
        String s3 = s.substring(fin + 1, s.length());
        String result = s1;
        for(int i = s2.length() - 1; i >= 0; --i)
            result += s2.charAt(i);
        result += s3;

        return result;
    }

    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        while(s.contains("/")) {
            s = Reverse(s);
        }

        System.out.println(s);
    }
}
