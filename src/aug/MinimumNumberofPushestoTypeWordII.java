package aug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumNumberofPushestoTypeWordII {
	public static void main(String[] args) {
		String word1="abcde";
		String word2="xyzxyzxyzxyz";
		String word3="aabbccddeeffgghhiiiiii";
		
		System.out.println(minimumPushes(word1));
		System.out.println(greedySorting(word2));
		System.out.println(usingHeap(word3));
	}

	private static int minimumPushes(String word) {
		int[] counts=new int[26];
		for (int i = 0; i < word.length(); i++) {
			counts[word.charAt(i)-'a']++;
		}
		Arrays.sort(counts);
		int res = 0;
		for (int i = 25; i >0; i--) {
			res += Math.ceil((25-i+1)/8.0) * counts[i];
		}
		return  res;
	}
	
	private static int greedySorting(String word) {
		  // Frequency array to store count of each letter
        int[] frequency = new int[26];

        // Count occurrences of each letter
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Sort frequencies in descending order
        Arrays.sort(frequency);
        int[] sortedFrequency = new int[26];
        for (int i = 0; i < 26; i++) {
            sortedFrequency[i] = frequency[25 - i];
        }
        
        /*
        // Or do like this 
        // Sort frequencies in descending order
        Integer[] sortedFrequency = Arrays.stream(frequency).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedFrequency, (a, b) -> b - a);
        */

        int totalPushes = 0;

        // Calculate total number of presses
        for (int i = 0; i < 26; i++) {
            if (sortedFrequency[i] == 0) break;
            totalPushes += (i / 8 + 1) * sortedFrequency[i];
        }

        return totalPushes;
	}
	
	
	private static int usingHeap(String word) {
	
		// Frequency map to store count of each letter
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each letter
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Priority queue to store frequencies in descending order
        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>(
            (a, b) -> b - a
        );
        frequencyQueue.addAll(frequencyMap.values());

        int totalPushes = 0;
        int index = 0;

        // Calculate total number of presses
        while (!frequencyQueue.isEmpty()) {
            totalPushes += (index / 8 + 1) * frequencyQueue.poll();
            index++;
        }

        return totalPushes;
	}
}
