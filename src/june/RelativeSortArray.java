package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray {

	 public static int[] relativeSortArray(int[] arr1, int[] arr2) {
	        // Step 1: Count the frequency of each element in arr1
	        Map<Integer, Integer> freqMap = new HashMap<>();
	        for (int num : arr1) {
	            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
	        }

	        // Step 2: Initialize the result list
	        List<Integer> result = new ArrayList<>();

	        // Step 3: Add elements from arr2 in the order they appear in arr2
	        for (int num : arr2) {
	            if (freqMap.containsKey(num)) {
	                for (int i = 0; i < freqMap.get(num); i++) {
	                    result.add(num);
	                }
	                freqMap.remove(num);
	            }
	        }

	        // Step 4: Collect the remaining elements that are not in arr2
	        List<Integer> remainingElements = new ArrayList<>();
	        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
	            for (int i = 0; i < entry.getValue(); i++) {
	                remainingElements.add(entry.getKey());
	            }
	        }

	        // Step 5: Sort the remaining elements
	        Collections.sort(remainingElements);

	        // Step 6: Append the sorted remaining elements to the result list
	        result.addAll(remainingElements);

	        // Convert result list to array
	        int[] resultArray = new int[result.size()];
	        for (int i = 0; i < result.size(); i++) {
	            resultArray[i] = result.get(i);
	        }

	        return resultArray;
	    }

	    public static void main(String[] args) {
	        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
	        int[] arr2 = {2, 1, 4, 3, 9, 6};
	        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2))); // Output: [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]

	        int[] arr1_2 = {28, 6, 22, 8, 44, 17};
	        int[] arr2_2 = {22, 28, 8, 6};
	        System.out.println(Arrays.toString(relativeSortArray(arr1_2, arr2_2))); // Output: [22, 28, 8, 6, 17, 44]
	    }
}
