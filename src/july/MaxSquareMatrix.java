package july;

public class MaxSquareMatrix {

	 public static void main(String[] args) {
	        int[][] mat1 = {
	            {0, 1, 1, 0, 1},
	            {1, 1, 0, 1, 0},
	            {0, 1, 1, 1, 0},
	            {1, 1, 1, 1, 0},
	            {1, 1, 1, 1, 1},
	            {0, 0, 0, 0, 0}
	        };
	        System.out.println(maxSquare(mat1)); // Output: 3

	        int[][] mat2 = {
	            {1, 1},
	            {1, 1}
	        };
	        System.out.println(maxSquare(mat2)); // Output: 2

	        int[][] mat3 = {
	            {0, 0},
	            {0, 0}
	        };
	        System.out.println(maxSquare(mat3)); // Output: 0
	    }

	    public static int maxSquare(int[][] mat) {
	        int n = mat.length;
	        int m = mat[0].length;
	        int[][] dp = new int[n][m];
	        int maxSide = 0;

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (i == 0 || j == 0) {
	                    dp[i][j] = mat[i][j];
	                } else if (mat[i][j] == 1) {
	                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
	                } else {
	                    dp[i][j] = 0;
	                }
	                maxSide = Math.max(maxSide, dp[i][j]);
	            }
	        }
	        return maxSide;
	    }
}
