package june;

public class ConsecutiveOdds {
	public static boolean threeConsecutiveOdds(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num % 2 == 1) {
				count++;
				if (count == 3) {
					return true;
				}
			} else {
				count = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// Example 1
		int[] arr1 = { 2, 6, 4, 1 };
		System.out.println(threeConsecutiveOdds(arr1)); // Output: false

		// Example 2
		int[] arr2 = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };
		System.out.println(threeConsecutiveOdds(arr2)); // Output: true
	}
}
