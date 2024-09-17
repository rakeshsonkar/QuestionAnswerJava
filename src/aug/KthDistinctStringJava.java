package aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KthDistinctStringJava {
	public static void main(String[] args) {
		String[] arr1 = { "d", "b", "c", "b", "c", "a" };
		int k1 = 2;
		System.out.println(kthDistinct(arr1, k1)); // Output: "a"

		String[] arr2 = { "aaa", "aa", "a" };
		int k2 = 1;
		System.out.println(kthDistinct(arr2, k2)); // Output: "aaa"

		String[] arr3 = { "a", "b", "a" };
		int k3 = 3;
		System.out.println(kthDistinct(arr3, k3)); // Output: ""
	}

	public static String kthDistinctJava8(String[] arr, int k) {
		Map<String, Long> countMap = Arrays.stream(arr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(countMap);

		List<String> distinctList = Arrays.stream(arr).filter(s -> countMap.get(s) == 1).distinct()
				.collect(Collectors.toList());

		System.out.println(distinctList);

		return k <= distinctList.size() ? distinctList.get(k - 1) : "";

	}

	public static String kthDistinct(String[] arr, int k) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (String s : arr) {
			countMap.put(s, countMap.getOrDefault(s, 0) + 1);
		}

		List<String> distinctList = new ArrayList<String>();
		for (String s : arr) {
			if (countMap.get(s) == 1) {
				distinctList.add(s);
			}
		}

		if (k <= distinctList.size()) {
			return distinctList.get(k - 1);
		} else {
			return "";
		}

	}

	public static String bruteForcekthDistinct(String[] arr, int k) {
		int n = arr.length;
		List<String> distinctStrings = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String currentString = arr[i];
			boolean isDistinct = true;

			for (int j = 0; j < n; j++) {
				if (j == i)
					continue;
				if (arr[j].equals(currentString)) {
					isDistinct = false;
					break;
				}
			}

			if (isDistinct) {
				distinctStrings.add(currentString);
			}
		}

		if (distinctStrings.size() < k) {
			return "";
		}
		return distinctStrings.get(k - 1);

	}

	public static String hashSetkthDistinct(String[] arr, int k) {
		Set<String> distinctStrings = new HashSet<String>();
		Set<String> duplicateStrings = new HashSet<String>();

		for (String str : arr) {
			if (duplicateStrings.contains(str)) {
				continue;
			}
			if (distinctStrings.contains(str)) {
				distinctStrings.remove(str);
				duplicateStrings.add(str);
			} else {
				distinctStrings.add(str);
			}

		}
		for (String s : arr) {
			if (!duplicateStrings.contains(s)) {
				k--;
			}
			if (k == 0) {
				return s;
			}
		}
		return "";

	}
	
	public static String hashMapkthDistinct(String[] arr, int k) {
		Map<String, Integer> frequencyMap = new HashMap<>();
		
		// First pass: Populate the frequency map
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        
        // Second pass: Find the k-th distinct string
        for (String str : arr) {
            // Check if the current string is distinct
            if (frequencyMap.get(str) == 1) {
                k--;
            }
            // When k reaches 0, we have found the k-th distinct string
            if (k == 0) {
                return str;
            }
        }
        
        return "";
	}
	

}
