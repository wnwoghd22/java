public class shiftArr{
	public static void Shift(String[] _arr) {
		String temp = _arr[_arr.length - 1];

		for(int i = _arr.length - 1; i >= 1; --i) {
			_arr[i] = _arr[i - 1];
		}
		_arr[0] = temp;
	}
}