import java.util.*;

public class MaxPathVal {
	public static boolean debug;
	public static int n, q;
	public static int Dijkstra(int data[][], final int _start, final int _end, int sequence[]) {
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];
		int minCost;
		int nextV = -1;
		boolean flag = false;

		for (int i = 0; i < n; ++i) {
			flag = false;
			for(int j = 1; j < data[_start].length; ++j) if(data[_start][j] == i) { flag = true; break; }
			distance[i] = flag ? 1 : Integer.MAX_VALUE / 2;
			if (distance[i] < Integer.MAX_VALUE / 2) sequence[i] = _start;
			visited[i] = false;
		}
if(debug) {
	System.out.print("distance : ");
	for(int i = 0; i < distance.length; ++i) System.out.print(distance[i] + " ");
	System.out.println("");

	System.out.print("sequence : ");
	for(int i = 0; i < sequence.length; ++i) System.out.print(sequence[i] + " ");
	System.out.println("");
}
		visited[_start] = true;

		for (int i = 0; i < n; ++i) {
			minCost = Integer.MAX_VALUE / 2;

			for (int j = 0; j < n; ++j) {
				if (distance[j] < minCost && !visited[j]) {
					minCost = distance[j];
					nextV = j;
				}
			}
if(debug) System.out.println(minCost  + ", " + nextV);

			visited[nextV] = true;

			for (int k = 0; k < n; ++k) {
				if (!visited[k]) {
					flag = false;
					for(int j = 1; j < data[k].length; ++j) if(data[k][j] == nextV) { flag = true; break; }
					int edge = flag ? 1 : Integer.MAX_VALUE / 2;
					if (minCost + edge < distance[k]) {
						distance[k] = minCost + edge;
						sequence[k] = nextV;
					}
				}	
			}
if(debug) {
	System.out.print("distance : ");
	for(int idx = 0; idx < distance.length; ++idx) System.out.print(distance[idx] + " ");
	System.out.println("");

	System.out.print("sequence : ");
	for(int idx = 0; idx < sequence.length; ++idx) System.out.print(sequence[idx] + " ");
	System.out.println("");
}
		}
		return distance[_end];
	}
	public static int MaxPathVal(int data[][], final int start, final int end) {
		int[] sequence = new int[n];
		for (int i = 0; i < n; ++i) sequence[i] = -1;
		int maxVal = 0;

		int result = Dijkstra(data, start, end, sequence);
		
if(debug) for(int i = 0; i < sequence.length; ++i) System.out.print(sequence[i] + " ");

		int[] order = new int[n];
		order[0] = end; int sort = end; int idx = 0;
		while (sort != start) {
			order[++idx] = sequence[sort];
			sort = sequence[sort];
		}
	
		while (true) {
if(debug) System.out.println(order[idx] + " - ");
			if (data[order[idx]][0] > maxVal) maxVal = data[order[idx]][0];
			if (order[idx--] == end) break;
		}

		return maxVal;
	}

	public static void main(String args[]) {
		debug = false;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); q = sc.nextInt();

		int[][] data = new int[n][1];
		for(int i = 0; i < n; ++i) data[i][0] = sc.nextInt();
		for(int i = 0; i < n - 1; ++i) {
			int p = sc.nextInt() - 1, c = sc.nextInt() - 1;
			data[p] = Arrays.copyOf(data[p], data[p].length + 1); data[p][data[p].length - 1] = c;
			data[c] = Arrays.copyOf(data[c], data[c].length + 1); data[c][data[c].length - 1] = p;
		}

if(debug) {
	for(int i = 0; i < data.length; ++i) {
		for(int j = 0; j < data[i].length; ++j)
			System.out.print(data[i][j] + " ");
		System.out.println("");
	}
}
		for(int i = 0; i < q; ++i) {
			int pre = sc.nextInt(), fin = sc.nextInt();
			System.out.println(MaxPathVal(data, pre - 1, fin - 1));
		}
	}	
}