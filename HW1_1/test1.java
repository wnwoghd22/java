import java.util.Scanner;

class TestClass {
    public static void main(String args[]) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            String s = sc.next();

            if(
                s.contains("a") &&
                s.contains("e") &&
                s.contains("i") &&
                s.contains("o") &&
                s.contains("u") ||
                s.contains("A") &&
                s.contains("E") &&
                s.contains("I") &&
                s.contains("O") &&
                s.contains("U")
            )
                System.out.println("lovely string");
            else
                System.out.println("ugly string");
        }
    }
}