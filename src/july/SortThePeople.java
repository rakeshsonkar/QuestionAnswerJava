package july;

import static java.util.Collections.reverseOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortThePeople {
	public static void main(String[] args) {
		String[] names = { "Mary", "John", "Emma" };
		int[] heights = { 180, 165, 170 };
		System.out.println(sortPeopleSortedMap(names, heights));

		System.out.println(sortPeopleSortPermutation(names, heights));

	}

	public static String[] sortPeople(String[] names, int[] heights) {
		Map<Integer, String> mp = new HashMap<>();

		for (int i = 0; i < heights.length; i++) {
			mp.put(heights[i], names[i]);
		}

		List<Entry<Integer, String>> sorted_map = mp.entrySet().stream()
				.sorted(reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());

		System.out.println(sorted_map);
		// StringBuilder str = new StringBuilder();
		String[] ans = new String[sorted_map.size()];
		int index = 0;
		for (Entry<Integer, String> s : sorted_map) {
			// System.out.println(s.getValue());
			ans[index++] = s.getValue();
		}

		return ans;
	}

	public static String[] sortPeople2(String[] names, int[] heights) {

		Map<Integer, String> heightToNameMap = new HashMap<>();

		for (int i = 0; i < names.length; i++) {
			heightToNameMap.put(heights[i], names[i]);
		}

		Arrays.sort(heights);
		String[] sortedNmaes = new String[names.length];

		for (int i = names.length - 1; i >= 0; i--) {
			sortedNmaes[names.length - i - 1] = heightToNameMap.get(heights[i]);
		}
		for (int i = 0; i < sortedNmaes.length; i++) {
			System.out.println(sortedNmaes[i]);
		}
		return sortedNmaes;
	}

	public static String[] sortPeopleSortedMap(String[] names, int[] heights) {

		int numberOfPeople = names.length;

		TreeMap<Integer, String> heightToNameMap = new TreeMap<>();

		for (int i = 0; i < numberOfPeople; i++) {
			heightToNameMap.put(heights[i], names[i]);
		}

		String[] sortedNmaes = new String[numberOfPeople];

		int currentIndex = numberOfPeople - 1;

		for (int hight : heightToNameMap.keySet()) {

			sortedNmaes[currentIndex] = heightToNameMap.get(hight);
			currentIndex--;
		}

		/*
		 * for(int i=names.length -1;i>=0;i--) { sortedNmaes[names.length-i-1]
		 * =heightToNameMap.get(heights[i]); } for (int i = 0; i < sortedNmaes.length;
		 * i++) { System.out.println(sortedNmaes[i]); }
		 */

		for (String v : sortedNmaes) {
			System.out.println(v);
		}
		return sortedNmaes;
	}

	public static String[] sortPeopleSortPermutation(String[] names, int[] heights) {

		int numberOfPeople = names.length;

		// Create an array of indices
		Integer[] sortedIndices = new Integer[numberOfPeople];
		for (int i = 0; i < numberOfPeople; i++) {
			sortedIndices[i] = i;
		}
		Arrays.sort(sortedIndices, (a, b) -> heights[b] - heights[a]);

		// Apply the sorted indices to rearrange names
		String[] sortedName = new String[numberOfPeople];
		for (int i = 0; i < numberOfPeople; i++) {
			sortedName[i] = names[sortedIndices[i]];

		}
		for (int i = 0; i < sortedName.length; i++) {
			System.out.println(sortedName[i]);
		}
		return sortedName;
	}

///--------------------------------------------- Quick Sort ---------------------------------------------------------------
	public static String[] sortPeopleQuickSort(String[] names, int[] heights) {
		quickSort(heights, names, 0, heights.length - 1);
		return names;
	}

	private static void quickSort(int[] heights, String[] names, int start, int end) {
		if (start < end) {
			// find the partition index
			int partitionIndex = partition(heights, names, start, end);

			// Recursive sort the left and right sub- arrays
			quickSort(heights, names, start, partitionIndex - 1);
			quickSort(heights, names, partitionIndex + 1, end);
		}
	}

	private static int partition(int[] heights, String[] names, int start, int end) {
		int pivot = heights[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			// if current element is greater than or equal to pivot
			if (heights[j] >= pivot) {
				i++;
				swap(heights, names, i, j);
			}

		}

		swap(heights, names, i + 1, end);

		return i + 1;
	}

	private static void swap(int[] heights, String[] names, int index1, int index2) {
		// swap heights
		int tempHeight = heights[index1];
		heights[index1] = heights[index2];
		heights[index2] = tempHeight;

		// Swap corresponding names
		String tempName = names[index1];
		names[index1] = names[index2];
		names[index2] = tempName;

	}

	/// --------------------------------------------- Merge Sort
	/// ---------------------------------------------------------------

	public String[] sortPeopleMerge(String[] names, int[] heights) {
		mergeSort(names, heights, 0, heights.length - 1);
		return names;
	}

	private void mergeSort(String[] names, int[] heights, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(names, heights, start, end);
			mergeSort(names, heights, mid + 1, end);
			merge(names, heights, start, mid, end);
		}
	}

	private void merge(String[] names, int[] heights, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int leftSize = mid - start + 1;
		int rightSize = end - mid;

		// Create temporary arrays
		int[] leftHeights = new int[leftSize];
		int[] rightHeights = new int[rightSize];
		String[] leftNames = new String[leftSize];
		String[] rightNames = new String[rightSize];

		// Copy data to temporary arrays
		for (int i = 0; i < leftSize; i++) {
			leftHeights[i] = heights[start + i];
			leftNames[i] = names[start + i];
		}
		for (int j = 0; j < rightSize; j++) {
			rightHeights[j] = heights[mid + 1 + j];
			rightNames[j] = names[mid + 1 + j];
		}

		// Merge the temporary arrays
		int leftIndex = 0, rightIndex = 0;
		int mergeIndex = start;
		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (leftHeights[leftIndex] >= rightHeights[rightIndex]) { // Descending order
				heights[mergeIndex] = leftHeights[leftIndex];
				names[mergeIndex] = leftNames[leftIndex];
				leftIndex++;
			} else {
				heights[mergeIndex] = rightHeights[rightIndex];
				names[mergeIndex] = rightNames[rightIndex];
				rightIndex++;
			}
			mergeIndex++;
		}

		// Copy remaining elements of leftHeights[], if any
		while (leftIndex < leftSize) {
			heights[mergeIndex] = leftHeights[leftIndex];
			names[mergeIndex] = leftNames[leftIndex];
			leftIndex++;
			mergeIndex++;
		}

		// Copy remaining elements of rightHeights[], if any
		while (rightIndex < rightSize) {
			heights[mergeIndex] = rightHeights[rightIndex];
			names[mergeIndex] = rightNames[rightIndex];
			rightIndex++;
			mergeIndex++;
		}

	}

}
