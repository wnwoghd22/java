import java.util.*;

public class Main2 {
	public static void GetChar(int[] arr) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			char c = sc.next().charAt(0);
			
			if(c >= 'a' && c <= 'z') ++arr[c - 'a'];
			else if(c >= 'A' && c <= 'Z') ++arr[c - 'A'];
			else if(c == '!') break;
			else {
				System.out.println("invalid value!");
				continue;
			}
		}
	}
	public static void Sort(int[] count, int[] arr) {
		for(int i = 0; i < count.length - 1; ++i) {
			for(int j = 0; j < count.length - i - 1; ++j) {
				if(count[j] > count[j + 1]) {
					int temp1 = count[j], temp2 = arr[j];
					count[j] = count[j + 1]; arr[j] = arr[j + 1];
					count[j + 1] = temp1; arr[j + 1] = temp2;
				}
			}
		}
	}
	public static void getMed(int[] count, int[] arr) {
		double mean = 0.0; int n = 0;
		for(int i = 0; i < count.length; ++i) {
			if(count[i] > 0) ++n;
			mean += count[i];
		} mean /= n; //System.out.println("mean : " + mean);
		
		double gap = Math.abs(count[0] - mean); int med = 0;
		for(int i = 1; i < count.length; ++i) {
			if(med == 0) med = count[i];
			if(gap < Math.abs(count[i] - mean)) { med = count[i - 1]; break; }
			gap = Math.abs(count[i] - mean);
		}
		System.out.print("Median : "); //System.out.println(med);
		for(int i = 0; i < count.length; ++i) {
			if(count[i] == 0) continue;
			if(count[i] == med) {
				System.out.printf("%c or %c",  'a' + arr[i], 'A' + arr[i]);
				if(i < count.length - 1 && count[i + 1] == med) { System.out.print("/"); continue; }
				else break;
			}
			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int[] count = new int['Z' - 'A' + 1];
		int[] arr = new int['Z' - 'A' + 1];
		for(int i = 0; i < arr.length; ++i) arr[i] = i;
		
		GetChar(count);
		
		for(int i = 0; i < count.length; ++i) {
			if(count[i] > 0) {
					System.out.printf("%c or %c : %d\n", 'a' + i, 'A' + i, count[i]);
					
			}
		}
		
		Sort(count, arr);
		
		System.out.print("Maximum : ");
		for(int i = count.length - 1; i >= 0; --i) {
			System.out.printf("%c or %c",  'a' + arr[i], 'A' + arr[i]);
			if(i > 0 && count[i - 1] == count[i]) { System.out.print("/"); continue; }
			else break;
		}
		System.out.println("");
		System.out.print("Minimum : ");
		for(int i = 0; i < count.length; ++i) {
			if(count[i] == 0) continue;
			System.out.printf("%c or %c",  'a' + arr[i], 'A' + arr[i]);
			if(i < count.length - 1 && count[i + 1] == count[i]) { System.out.print("/"); continue; }
			else break;
		}
		System.out.println("");
		getMed(count, arr);
	}
}