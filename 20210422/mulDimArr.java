public class mulDimArr{
	public static void main(String args[]) {
		int[][] matrix = new int[5][7];

		for(int i = 0; i < matrix.length; ++i)
			for(int j = 0; j < matrix[i].length; ++j)
				matrix[i][j] = (int)(Math.random() * 100);
	
		for(int i = 0; i < matrix.length; ++i) {
			double sum = 0.0;
			for(int j = 0; j < matrix[i].length; ++j) {
				System.out.printf("%5d ", matrix[i][j]);
				sum += matrix[i][j];
			}
			double mean = Math.floor(sum / matrix[i].length * 100) / 100;
			System.out.println("|" + mean);
		}
		System.out.println("------------------------------------------+-----");
		for(int i = 0; i < matrix[0].length; ++i) {
			double sum = 0.0;
			for(int j = 0; j < matrix.length; ++j) {
				sum += matrix[j][i];
			}
			double mean = Math.floor(sum / matrix.length * 100) / 100;
			System.out.printf("%5.2f ", mean);
		}
		System.out.print("|");

		double total = 0.0;
		for(int i = 0; i < matrix.length; ++i)
			for(int j = 0; j < matrix[i].length; ++j)
				total += matrix[i][j];

		double total_mean = Math.floor(total / (matrix.length * matrix[0].length) * 100) / 100;
		System.out.println(total_mean);
	}
}