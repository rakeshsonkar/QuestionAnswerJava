package june;

import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {

	public static void main(String[] args) {
		HandOfStraights hds=new HandOfStraights();
		 int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
	        int groupSize1 = 3;
	        System.out.println(hds.isNStraightHand(hand1, groupSize1)); // Output: true

	        int[] hand2 = {1, 2, 3, 4, 5};
	        int groupSize2 = 4;
	        System.out.println(hds.isNStraightHand(hand2, groupSize2)); // Output: false
	}
	public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int card:hand)
            freq.put(card,freq.getOrDefault(card,0)+1);
        for(int card:hand){
            if(freq.get(card)==0)
                continue;
            for(int next=0;next<groupSize;next++){	
                int curr=card+next;
                if(freq.getOrDefault(curr,0)==0)
                    return false;
                freq.put(curr,freq.get(curr)-1);
            }
        }
        return true;
    }
}
