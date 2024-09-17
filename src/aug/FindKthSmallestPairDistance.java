package aug;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 1 };
		int k = 1;
		int[] nums1 = { 1, 1, 1 };
		int k1 = 2;
		int[] nums2 = { 1, 6, 1 };
		int k2 = 3;
		
		System.out.println(bucketSortSmallestDistancePair(nums, k));
		System.out.println(binarySearchDynamicProgrammingSmallestDistancePair(nums1, k1));
		System.out.println(binarySearchSlidingWindowSmallestDistancePair(nums2, k2));

	}

	public static int bucketSortSmallestDistancePair(int[] nums, int k) {
		int arrayLength = nums.length;

		// Find the maximum element in the array
		int maxElement = Integer.MIN_VALUE;
		for (int num : nums) {
			maxElement = Math.max(maxElement, num);
		}

		// Initialize a bucket array to store counts of each distance
		int[] distanceBucket = new int[maxElement + 1];
		// Populate the bucket array with counts of each distance
		for (int i = 0; i < arrayLength; ++i) {
			for (int j = i + 1; j < arrayLength; ++j) {
				// Compute the distance between nums[i] and nums[j]
				int distance = Math.abs(nums[i] - nums[j]);

				// Increment the count for this distance in the bucket
				++distanceBucket[distance];
			}
		}
		// Find the k-th smallest distance
		for (int dist = 0; dist <= maxElement; ++dist) {
			// Reduce k by the number of pairs with the current distance
			k -= distanceBucket[dist];

			// If k is less than or equal to 0, return the current distance
			if (k <= 0) {
				return dist;
			}
		}

		return -1; // Return -1 if no distance found, should not reach here
	}

	public static int binarySearchDynamicProgrammingSmallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int arraySize = nums.length;
		int maxElement = nums[arraySize - 1];

		// Number of computed prefixes
		int prefixCountSize = maxElement * 2;

		// Initialize prefix counts and value counts
		int[] prefixCount = new int[prefixCountSize];
		int[] valueCount = new int[maxElement + 1];

		// Compute prefix counts and value counts
		int prefixIndex = 0;
		for (int value = 0; value < prefixCountSize; ++value) {
			while (prefixIndex < arraySize && nums[prefixIndex] <= value) {
				++prefixIndex;
			}
			prefixCount[value] = prefixIndex;
		}
		for (int i = 0; i < arraySize; ++i) {
			++valueCount[nums[i]];
		}

		// Binary search to find kth smallest distance
		int left = 0;
		int right = maxElement;
		while (left < right) {
			int middle = (left + right) / 2;

			// Compute number of pairs with distance <= middle
			int count = countPairs(nums, prefixCount, valueCount, middle);

			// Adjust bounds for binary search
			if (count < k) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return left;
	}

	private static int countPairs(int[] nums, int[] prefixCount, int[] valueCount, int maxDistance) {
		int count = 0;
		int arraySize = nums.length;
		int index = 0;
		while (index < arraySize) {
			int currentValue = nums[index];
			int valueCountForCurrent = valueCount[currentValue];
			int pairsWithLargerValues = prefixCount[Math.min(currentValue + maxDistance, prefixCount.length - 1)]
					- prefixCount[currentValue];
			int pairsWithSameValues = (valueCountForCurrent * (valueCountForCurrent - 1)) / 2;
			count += pairsWithLargerValues * valueCountForCurrent + pairsWithSameValues;
			while (index + 1 < arraySize && nums[index] == nums[index + 1]) {
				++index;
			}
			++index;
		}
		return count;
	}

	public static int binarySearchSlidingWindowSmallestDistancePair(int[] nums, int k) {

		Arrays.sort(nums);
		int arraySize = nums.length;

		// Initialize binary search range
		int low = 0;
		int high = nums[arraySize - 1] - nums[0];

		while (low < high) {
			int mid = (low + high) / 2;

			// Count pairs with distance <= mid
			int count = countPairsWithMaxDistance(nums, mid);

			// Adjust binary search bounds based on count
			if (count < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private static int countPairsWithMaxDistance(int[] nums, int maxDistance) {
		int count = 0;
		int arraySize = nums.length;
		int left = 0;

		for (int right = 0; right < arraySize; ++right) {
			// Adjust the left pointer to maintain the window with distances <=
			// maxDistance
			while (nums[right] - nums[left] > maxDistance) {
				++left;
			}
			// Add the number of valid pairs ending at the current right index
			count += right - left;
		}
		return count;
	}
}
