package july;

public class RowWithMostOnes {
	public static int rowWithMostOnes(int[][] arr) {
		int numRows = arr.length;
		int numCols = arr[0].length;

		int maxRowIndex = -1;
		@SuppressWarnings("unused")
		int maxCount = 0;
		int col = numCols - 1; // Start from the top-right corner

		for (int row = 0; row < numRows; row++) {
			// Move left while there are 1's in this row
			while (col >= 0 && arr[row][col] == 1) {
				col--;
				maxRowIndex = row; // Update maxRowIndex to the current row
			}
		}

		return maxRowIndex;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println(rowWithMostOnes(arr1)); // Output: 2
		System.out.println(rowWithMax1s2(arr1));
		
		int[][] arr2 = { { 0, 0 }, { 1, 1 } };
		System.out.println(rowWithMostOnes(arr2)); // Output: 1
		System.out.println(rowWithMax1s2(arr2));
	}
	
	
	public static int rowWithMax1s2(int arr[][]) {
        for (int col = 0; col < arr[0].length; col++) {
           for (int row = 0; row < arr.length; row++) {
               if (arr[row][col] == 1) {
                   return row;
               }
           }
       }
       
       return -1;
   }
}
