package sep.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindDuplicateElements {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,3,2,1,6,6,6,5,4,6};
		for (int i = 0; i < arr.length; i++) {
			for(int j=i+1; j< arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("FindDuplicateElements :  " +arr[i]);
				}
			}
		}
		
		
		
		String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };
		
		// First solution : finding duplicates using brute force method
        System.out.println("Finding duplicate elements in array using brute force method");
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j]) ) {
                   // got the duplicate element
                }
            }
        }
        
     // Second solution : use HashSet data structure to find duplicates
        System.out.println("Duplicate elements from array using HashSet data structure");
        Set<String> store = new HashSet<>();

        for (String name : names) {
            if (store.add(name) == false) {
                System.out.println("found a duplicate element in array : "
                        + name);
            }
        }
        
        
     // Third solution : using Hash table data structure to find duplicates
        System.out.println("Duplicate elements from array using hash table");
        Map<String,Integer> nameAndCount = new HashMap<>();

        // build hash table with count
        for (String name : names) {
            Integer count = nameAndCount.get(name);
            if (count == null) {
                nameAndCount.put(name, 1);
            } else {
                nameAndCount.put(name, ++count);
            }
        }
        
     // Print duplicate elements from array in Java
        Set<Entry<String, Integer>> entrySet = nameAndCount.entrySet();
        for (Entry<String,Integer> entry : entrySet) {

            if (entry.getValue() > 1) {
                System.out.println("Duplicate element from array : "
                        + entry.getKey());
            }
        }
	}
}
