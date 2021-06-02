import java.util.*;

class treeCount {
    public static boolean debug;
    public static int xVal;
    public static final int modNum = 1000000007;
    public static void AddNode(int[][] edge, int n1, int n2) {
        int[] temp = new int[edge[n1].length + 1];
        for(int i = 1; i < edge[n1].length; ++i)
            temp[i] = edge[n1][i];
        temp[edge[n1].length] = n2;
        edge[n1] = temp;
    }
    public static int[] Calculate(int[][] x) {
        int[] result = new int[xVal];
        long pow = 1;
        for(int i = 0; i < x.length; ++i)
            pow = pow * x[i][0] % modNum;
        result[0] = (int)pow;
        for(int i = 1; i < xVal; ++i) {
            pow = 1;
            for(int j = 0; j < x.length; ++j)
                pow = pow * x[j][i] % modNum;
            result[i] = (int)((pow + result[i - 1]) % modNum);
        }
        return result;
    }
    public static int[] Cumulate(
        boolean[] visited, int[][] edge, int idx) {
        visited[idx] = true;
        int[] result = new int[xVal];
        if(edge[idx].length == 2 && visited[edge[idx][1]]) {
            for(int i = 0; i < xVal; ++i)
                result[i] = i + 1;
        } //leaf
        else {
            int[][] temp = new int[edge[idx].length - 1][xVal];
            for(int i = 1; i < edge[idx].length; ++i) {
                temp[i - 1] = Cumulate(visited, edge, edge[idx][i]);
            }

            result = Calculate(temp);
            temp = null;
        }

        return result;
    }
    public static int Simulate(boolean[] visited, int[][] edge) {
        
        int[] temp = Cumulate(visited, edge, 0);

if(debug)
        for(int i = 0; i < temp.length; ++i) {
            System.out.println(Arrays.toString(temp));
        }

        return temp[xVal - 1];
    }

    public static void main(String args[] ) throws Exception {
        debug = false;
       Scanner sc = new Scanner(System.in);

       short t = sc.nextShort(); int n;

       while(t-- > 0) {
           n = sc.nextInt(); xVal = sc.nextInt();
           int[][] edge = new int[n][1];
           boolean[] visited = new boolean[n];

            for(int i = 0; i < n - 1; ++i) {
                int n1 = sc.nextInt() - 1, n2 = sc.nextInt() - 1;
                AddNode(edge, n1, n2); AddNode(edge, n2, n1);
            }
if(debug)
            for(int i = 0; i < edge.length; ++i) {
                System.out.println(Arrays.toString(edge[i]));
            }

            System.out.println(Simulate(visited, edge));
       }
    }
}
