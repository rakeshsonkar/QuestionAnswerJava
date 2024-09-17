package july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTheJumbledNumbers {

	public static void main(String[] args) {
		int[] mapping = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
		int[] nums = { 991, 338, 38 };
		int[] ans = sortJumbled(mapping, nums);
		for (int val : ans) {
			System.out.println(val);
		}

	}

	public static int[] sortJumbled(int[] mapping, int[] nums) {
		List<Integer> numsList = new ArrayList<>();
		for (int num : nums) {
			numsList.add(num);
		}

		// Sort the list using a custom comparator
		numsList.sort((a, b) -> {
			long mappedA = getMappedValue(mapping, a);
			long mappedB = getMappedValue(mapping, b);
			if (mappedA == mappedB) {
				return 0;
			} else {
				return Long.compare(mappedA, mappedB);
			}
		});

		// Convert the sorted list back to an array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numsList.get(i);
		}

		return nums;
	}

	private static long getMappedValue(int[] mapping, int num) {
		StringBuilder mappedValue = new StringBuilder();
		String numStr = String.valueOf(num);

		for (char digit : numStr.toCharArray()) {
			mappedValue.append(mapping[digit - '0']);
		}

		// Convert the mapped value back to a long to handle potential leading zeros
		return Long.parseLong(mappedValue.toString());
	}
	
	public  static int[] ConversionUsingStringsAndSorting(int[] mapping,int[] nums ) {
		ArrayList<Integer[]> storepairs = new ArrayList<>();
		
		for(int i=0;i<nums.length;i++) {
			String number =  Integer.toString(nums[i]);
			String formed="";
			for(int j=0;j<number.length();j++) {
				formed=formed + Integer.toString(mapping[number.charAt(j)-'0']);
			}
			int mappedValue = Integer.parseInt(formed);
			storepairs.add(new Integer[] {mappedValue,i});
		}
		Collections.sort(
				storepairs,new Comparator<Integer[]>() {

					@Override
					public int compare(Integer[] o1, Integer[] o2) {
						return o1[0].compareTo(o2[0]);
					}
					
				}
				);
		
		int[] answer = new int[nums.length];
		for(int i=0;i<storepairs.size();i++) {
			answer[i]= nums[storepairs.get(i)[1]];
		}
		
		return answer;
	}
	
	
}
