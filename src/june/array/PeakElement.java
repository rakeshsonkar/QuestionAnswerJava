package june.array;

public class PeakElement {
	public static int peakElement(int[] arr, int n) {
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] < arr[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		System.out.println(peakElement(arr1, arr1.length)); // Output: 2

		int[] arr2 = { 1, 1, 1, 2, 1, 1, 1 };
		System.out.println(peakElement(arr2, arr2.length)); // Output: 3 (or any valid peak index)
	}
}
