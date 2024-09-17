package july;

import java.util.Arrays;

public class CountSmallerElements {

	 public static int[] countSmaller(int[] nums) {
	        int n = nums.length;
	        int[] result = new int[n];
	        int[] indexes = new int[n];

	        // Initialize indexes
	        for (int i = 0; i < n; i++) {
	            indexes[i] = i;
	        }

	        mergeSort(nums, indexes, result, 0, n - 1);

	        return result;
	    }

	    private static void mergeSort(int[] nums, int[] indexes, int[] result, int left, int right) {
	        if (left >= right) {
	            return;
	        }

	        int mid = (left + right) / 2;
	        mergeSort(nums, indexes, result, left, mid);
	        mergeSort(nums, indexes, result, mid + 1, right);
	        merge(nums, indexes, result, left, mid, right);
	    }

	    private static void merge(int[] nums, int[] indexes, int[] result, int left, int mid, int right) {
	      //  int[] temp = new int[right - left + 1];
	        int[] tempIndexes = new int[right - left + 1];

	        int i = left;
	        int j = mid + 1;
	        int k = 0;
	        int rightCount = 0;

	        while (i <= mid && j <= right) {
	            if (nums[indexes[j]] < nums[indexes[i]]) {
	                tempIndexes[k] = indexes[j];
	                rightCount++;
	                j++;
	            } else {
	                tempIndexes[k] = indexes[i];
	                result[indexes[i]] += rightCount;
	                i++;
	            }
	            k++;
	        }

	        while (i <= mid) {
	            tempIndexes[k] = indexes[i];
	            result[indexes[i]] += rightCount;
	            i++;
	            k++;
	        }

	        while (j <= right) {
	            tempIndexes[k] = indexes[j];
	            j++;
	            k++;
	        }

	        for (i = left; i <= right; i++) {
	            indexes[i] = tempIndexes[i - left];
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {12, 1, 2, 3, 0, 11, 4};
	        int[] result = countSmaller(arr);
	        System.out.println(Arrays.toString(result));  // Output: [6, 1, 1, 1, 0, 1, 0]

	        arr = new int[]{1, 2, 3, 4, 5};
	        result = countSmaller(arr);
	        System.out.println(Arrays.toString(result));  // Output: [0, 0, 0, 0, 0]
	    }
}
