public class RandomPW {
	private static char getRandChar(char c1, char c2) {
		return (char)(c1 + (int)(Math.random() * (c2 - c1)));
	}

	public static String RandPW(int n) {
		String temp = "";

		for(int i = 0; i < n; ++i){
			int r = (int)(Math.random() * 3);		

			switch(r) {
				case 0 : temp += getRandChar('0', '9'); break;
				case 1 : temp += getRandChar('a', 'z'); break;
				case 2 : temp += getRandChar('A', 'Z'); break;
				default: break;
			}
		}
		return temp;
	}
}