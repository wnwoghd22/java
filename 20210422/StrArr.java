import java.util.Scanner;

public class StrArr{
	private static String ConvertCase(String s) {
		final int gap = 'a' - 'A';

		String result = "";

		for(int i = 0; i < s.length(); ++i) {
			char temp = s.charAt(i);
			if(temp > 'A' && temp < 'Z') result += (char)(temp + gap);
			else if(temp > 'a' && temp < 'z') result += (char)(temp - gap);
			else result += temp;
		}
	
		return result;
	}
	private static String ConvertCase(String s, boolean b) {
		/****************************
			if b : upper case
			if !b : small
		****************************/
		final int gap = 'a' - 'A';

		String result = "";

		for(int i = 0; i < s.length(); ++i) {
			char temp = s.charAt(i);
			if(temp > 'A' && temp < 'Z') result += b ? temp : (char)(temp + gap);
			else if(temp > 'a' && temp < 'z') result += !b ? temp : (char)(temp - gap);
			else result += temp;
		}
	
		return result;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[5];
		String[] pwArr = new String[8];

		for(int i = 0; i < pwArr.length; ++i) pwArr[i] = RandomPW.RandPW(8);
		for(int i = 0; i < pwArr.length; ++i) System.out.println(pwArr[i]);
		System.out.println("convert \n");
		for(int i = 0; i < pwArr.length; ++i) {
			pwArr[i] = ConvertCase(pwArr[i]);
			System.out.println(pwArr[i]);
		}
		System.out.println("convert \n");
		for(int i = 0; i < pwArr.length; ++i) {
			pwArr[i] = ConvertCase(pwArr[i], true);
			System.out.println(pwArr[i]);
		}
		System.out.println("convert \n");
		for(int i = 0; i < pwArr.length; ++i) {
			pwArr[i] = ConvertCase(pwArr[i], false);
			System.out.println(pwArr[i]);
		}
		/***************
		for(int i = 0; i < arr.length; ++i) arr[i] = sc.nextLine();
		for(int i = 0; i < arr.length; ++i)
			System.out.println("arr " + i + " : " + arr[i]);
		***************/
	}
}