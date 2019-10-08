package Q4;

public class Matrix {
	public static int[][] mutiple(int[][] A, int[][] B) {
		int rowA = A.length;
		int rowB = B.length;
		int colB = B[0].length;
		int[][] result = new int[rowA][];
		for (int c = 0; c < colB; c++) {
			for (int i = 0; i < rowA; i++) {
				for (int j= 0; j < rowB; j++) {
					result[i][c] += A[i][j] * B[j][c];
				}
			}
		}
		return result;
	}
}
