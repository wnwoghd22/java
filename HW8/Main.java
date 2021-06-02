import java.util.*;

public class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int[] letterN = new int[26]; for(int i = 0; i < 26; ++i) letterN[i] = 0;
		int[] letterS = new int[26]; for(int i = 0; i < 26; ++i) letterS[i] = 0;
		int[] numN = new int[10]; for(int i = 0; i < 10; ++i) numN[i] = 0;

		System.out.print("input : "); String input = sc.nextLine();
		for(int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);
			if(c > 'A' && c < 'Z') {
				++letterN[c - 'A'];
				if(letterS[c - 'A'] == 0) letterS[c - 'A'] = 1;
				else if(letterS[c - 'A'] == 2) letterS[c - 'A'] = 3;
			}
			else if(c > 'a' && c < 'z') {
				++letterN[c - 'a'];
				if(letterS[c - 'a'] == 0) letterS[c - 'a'] = 2;
				else if(letterS[c - 'a'] == 1) letterS[c - 'a'] = 3;
			}
			else if(c > '0' && c < '9') ++numN[c - '0'];
		}

		for(int i = 0; i < letterN.length; ++i) {
			if(letterN[i] > 0) {
				String s = "";
				switch(letterS[i]) {
					case 1: s = "" + (char)('A' + i); break;
					case 2: s = "" + (char)('a' + i); break;
					case 3: s = (char)('a' + i) + " or " + (char)('A' + i); break;
					default: break;
				}
				System.out.printf("%-6s : %3d : ", s, letterN[i]);
				for(int j = 0; j < letterN[i]; ++j) System.out.print("*");
				System.out.println(""); 
			}
		}
		for(int i = 0; i < numN.length; ++i) {
			if(numN[i] > 0) {
				System.out.printf("%-6d : %3d : ", i, numN[i]);
				for(int j = 0; j < numN[i]; ++j) System.out.print("*");
				System.out.println(""); 
			}
		}
	}
}