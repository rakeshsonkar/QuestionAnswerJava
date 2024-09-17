package june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) {
		   int[] arr = {100, 90, 90, 80, 70};
	        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	        for (int i = 0; i < arr.length; i++) {
	            mp.putIfAbsent(arr[i], i + 1);
	        }
	    
	        int[] comList = {5,85,120};
		@SuppressWarnings("unused")
		ArrayList<Integer> res= new ArrayList<Integer>();
		
		for (int i = 0; i < comList.length; i++) {
			for(@SuppressWarnings("unused") Integer key:mp.keySet()) {
				
			}
		}
		
		
		
	}
}
