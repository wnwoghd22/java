

public class shiftTest{
	public static void main(String args[]) {
		String[] arr = new String[10];
		for(int i = 0; i < arr.length; ++i) arr[i] = RandomPW.RandPW(8);

		for(int i = 0; i < arr.length; ++i)
			System.out.println(i + ": " + arr[i]);

		shiftArr.Shift(arr);
		System.out.println("shift");

		for(int i = 0; i < arr.length; ++i)
			System.out.println(i + ": " + arr[i]);
	}
}