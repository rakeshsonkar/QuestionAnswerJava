package june;

public class PalindromeFinder {
	public static String findPalindrome(int[][] arr) {
		int n = arr.length;

		// Check each row for palindrome
		for (int i = 0; i < n; i++) {
			if (isPalindrome(arr[i])) {
				return i + " R";
			}
		}

		// Check each column for palindrome
		for (int j = 0; j < n; j++) {
			if (isPalindrome(getColumn(arr, j))) {
				return j + " C";
			}
		}

		// If no palindrome is found, return -1
		return "-1";
	}

	// Helper method to check if an array is a palindrome
	private static boolean isPalindrome(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (array[left] != array[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// Helper method to extract a column from a 2D array
	private static int[] getColumn(int[][] matrix, int col) {
		int[] column = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			column[i] = matrix[i][col];
		}
		return column;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 0, 0 }, { 0, 1, 0 }, { 1, 1, 0 } };
		int[][] arr2 = { { 1, 0 }, { 1, 0 } };

		System.out.println(findPalindrome(arr1)); // Output: 1 R
		System.out.println(findPalindrome(arr2)); // Output: 0 C
	}
}
