public class Print{
	public static void printArr(String[] sln) {
		for(int i = 0; i < sln.length; ++i)
			System.out.print(sln[i] + " ");
	}
	private static void Sort(int[] iln) {
		for(int i = 0; i < iln.length - 1; ++i) {
			for(int j = 0; j < iln.length - 1 - i; ++j) {
				if(iln[j] > iln[j + 1]) {
					int temp = iln[j];
					iln[j] = iln[j + 1];
					iln[j + 1] = temp;
				}
			}
		}
	}
	public static void printArr(int[] iln) {
		Sort(iln);
		for(int i = 0; i < iln.length; ++i)
			System.out.print(iln[i] + " ");		
	}
	private static void Sort(double[] dln) {
		for(int i = 0; i < dln.length - 1; ++i) {
			for(int j = 0; j < dln.length - 1 - i; ++j) {
				if(dln[j] > dln[j + 1]) {
					double temp = dln[j];
					dln[j] = dln[j + 1];
					dln[j + 1] = temp;
				}
			}
		}
	}
	public static void printArr(double[] dln) {
		Sort(dln);
		for(double d : dln)
			System.out.print(d + " ");		
	}

}