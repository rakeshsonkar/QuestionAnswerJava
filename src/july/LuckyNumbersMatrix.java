package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersMatrix {
	public static void main(String[] args) {
		int [][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
		System.out.println(luckyNumbers(matrix));
		
		int [][] matrixgd = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		System.out.println(approachGreedy(matrixgd));
		
	}
	
	 public static  List<Integer> luckyNumbers(int[][] matrix) {
	        int N = matrix.length, M = matrix[0].length;

	        List<Integer> rowMin = new ArrayList<>();
	        for (int i = 0; i < N; i++) {
	            int rMin = Integer.MAX_VALUE;
	            for (int j = 0; j < M; j++) {
	                rMin = Math.min(rMin, matrix[i][j]);
	            }
	            rowMin.add(rMin);
	        }

	        List<Integer> colMax = new ArrayList<>();
	        for (int i = 0; i < M; i++) {
	            int cMax = Integer.MIN_VALUE;
	            for (int j = 0; j < N; j++) {
	                cMax = Math.max(cMax, matrix[j][i]);
	            }
	            colMax.add(cMax);
	        }

	        List<Integer> luckyNumbers = new ArrayList<>();
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (matrix[i][j] == rowMin.get(i) && matrix[i][j] == colMax.get(j)) {
	                    luckyNumbers.add(matrix[i][j]);
	                }
	            }
	        }

	        return luckyNumbers;
	    }
	 
	 public static List<Integer> approachGreedy(int[][] matrix) {
	        int N = matrix.length, M = matrix[0].length;

	        int rMinMax = Integer.MIN_VALUE;
	        for (int i = 0; i < N; i++) {
	            int rMin = Integer.MAX_VALUE;
	            for (int j = 0; j < M; j++) {
	                rMin = Math.min(rMin, matrix[i][j]);
	            }
	            rMinMax = Math.max(rMinMax, rMin);
	        }

	        int cMaxMin = Integer.MAX_VALUE;
	        for (int i = 0; i < M; i++) {
	            int cMax = Integer.MIN_VALUE;
	            for (int j = 0; j < N; j++) {
	                cMax = Math.max(cMax, matrix[j][i]);
	            }
	            cMaxMin = Math.min(cMaxMin, cMax);
	        }

	        if (rMinMax == cMaxMin) {
	            return new ArrayList<>(Arrays.asList(rMinMax));
	        }

	        return new ArrayList<>();
	    }

}
