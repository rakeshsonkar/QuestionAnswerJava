package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortArraybyIncreasingFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 1, 2, 2, 2, 3 };
		int[] nums2 = { 2, 3, 1, 3, 2 };
		int[] nums3 = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };

		System.out.println(Arrays.toString(frequencySort(nums1))); // Output: [3, 1, 1, 2, 2, 2]
		System.out.println(Arrays.toString(frequencySortNew(nums2))); // Output: [1, 3, 3, 2, 2]
		System.out.println(Arrays.toString(frequencySort(nums3))); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
	}

	public static int[] frequencySort(int[] nums) {

		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}
		List<Integer> list = new ArrayList<>();

		for (int num : nums) {
			list.add(num);
		}

		list.sort((a, b) -> {
			int freqA = frequencyMap.get(a);
			int freqB = frequencyMap.get(b);
			if (freqA != freqB) {
				return Integer.compare(freqA, freqB);
			} else {
				return Integer.compare(b, a);
			}
		});

		for (int i = 0; i < nums.length; i++) {
			nums[i] = list.get(i);
		}

		return nums;
	}

	public static int[] frequencySortNew(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
				int compare = a.getValue().compareTo(b.getValue());
				if (compare == 0) {
					compare = b.getKey().compareTo(a.getKey());
				}
				return compare;
			}

		});

		int[] res = new int[nums.length];

		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			Map.Entry<Integer, Integer> e = list.get(i);
			int val = e.getKey();
			int freq = e.getValue();
			for (int j = 0; j < freq; j++) {
				res[idx++] = val;
			}
		}
		return res;

	}

}
