package june;

import java.util.HashMap;
import java.util.Map;

public class Fequ {

	public static void main(String[] args) {
		int[] p = { 1, 2, 4, 6, 8, 9 };
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : p) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		System.out.println(freqMap.getOrDefault(2, 0)+1);
	}

}
