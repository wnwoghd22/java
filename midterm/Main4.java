import java.util.*;

public class Main4 {
	public static void SearchString(String[] sList, boolean type) {
		int result = 0, len = sList[0].length();
		for(int i = 1; i < sList.length; ++i) {
			if(type) {
				if(sList[i].length() > len) {
					len = sList[i].length(); result = i;
				}
			} else {
				if(sList[i].length() < len) {
					len = sList[i].length(); result = i;
				}
			}
		}
		if(type) System.out.print("The longest String : ");
		else System.out.print("The shortest String : ");
		System.out.println(sList[result] + " (" + len + ")");
	}
	public static void SearchString(String[] sList) {
		System.out.println("The String with same length : ");
		boolean[] visited = new boolean[sList.length]; int len = 0, count = 0;
		for(int i = 0; i < sList.length - 1; ++i) {
			count = 0;
			if(visited[i]) continue;
			visited[i] = true; len = sList[i].length();
			for(int j = i + 1; j < sList.length;++j) {
				if(sList[j].length() == len) { visited[j] = true; ++count; }
			}
			if(count == 0) continue;
			for(int k = i; k < sList.length; ++k) {
				if(sList[k].length() == len) {
					System.out.print(sList[k]);
					if(count-- > 0) 
						System.out.print("/");
				}
			}
			System.out.println("(" + len + ")");
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = new String[0];
		
		while(true) {
			String temp = sc.next();
			if(temp.length() == 4
			&& temp.charAt(0) == 'q'
			&& temp.charAt(1) == 'u'
			&& temp.charAt(2) == 'i'
			&& temp.charAt(3) == 't') break;
			
			String[] tempArr = new String[arr.length + 1];
			for(int i = 0; i < arr.length; ++i) tempArr[i] = arr[i];
			tempArr[tempArr.length - 1] = temp;
			arr = tempArr;
		}
		SearchString(arr, true);
		SearchString(arr, false);
		SearchString(arr);
		
	}
}