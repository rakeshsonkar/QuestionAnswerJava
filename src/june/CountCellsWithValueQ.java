package june;

public class CountCellsWithValueQ {
	public static long countCellsWithValueQ(long n, long q) {
		// If q is out of the possible value range of the matrix
		if (q < 2 || q > 2 * n) {
			return 0;
		}

		// Calculate the valid range for i
		long start = Math.max(1, q - n);
		long end = Math.min(n, q - 1);

		// Count the number of valid i's
		long count = Math.max(0, end - start + 1);

		return count;
	}

	public static void main(String[] args) {
		// Example test cases
		System.out.println(countCellsWithValueQ(4, 7)); // Output: 2
		System.out.println(countCellsWithValueQ(5, 4)); // Output: 3
	}
}
