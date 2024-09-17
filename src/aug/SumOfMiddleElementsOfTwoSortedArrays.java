package aug;

public class SumOfMiddleElementsOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4, 6, 10 };
		int[] arr2 = { 4, 5, 6, 9, 12 };
		System.out.println(SumofMiddleElements(arr1, arr2));
		int[] arr3 = {1, 12, 15, 26, 38};
		int[] arr4 = {2, 13, 17, 30, 45};
		System.out.println(SumofMiddleElements(arr3, arr4));
	}

	private static int SumofMiddleElements(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int low = 0, high = n - 1, mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			int midSecond = n - mid - 1;
			int first1 = mid > 0 ? arr1[mid - 1] : Integer.MIN_VALUE;
			int second1 = arr1[mid];
			int first2 = midSecond > 0 ? arr2[midSecond - 1] : Integer.MIN_VALUE;
			int second2 = arr2[midSecond];
			int third1 = mid + 1 < n ? arr1[mid + 1] : Integer.MAX_VALUE;
			int third2 = midSecond + 1 < n ? arr2[midSecond + 1] : Integer.MAX_VALUE;
			int mx = Math.max(second1, second2);
			if (mx <= third1 && mx <= third2) {
				return mx + Math.max(Math.max(first1, first2), Math.min(second1, second2));
			} else if (mx > third1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return 0;
	}
}
