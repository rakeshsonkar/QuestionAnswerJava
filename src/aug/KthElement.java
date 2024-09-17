package aug;

import java.util.ArrayList;
import java.util.Collections;

public class KthElement {

	public static void main(String[] args) {
		int k=5;
		int[] arr1= {2,3,6,7,9};
		int[] arr2= {1,4,8,10};
		
		System.out.println(kthElementSol(k,arr1,arr2));
		
		System.out.println(kthElementChat(k,arr1,arr2));
	}
	public static long kthElementSol(int k, int arr1[], int arr2[]) {
	       ArrayList<Integer> list=new ArrayList<>();
	       for(int i=0;i<arr1.length;i++){
	           list.add(arr1[i]);
	       }
	       for(int i=0;i<arr2.length;i++){
	           list.add(arr2[i]);
	       }
	       Collections.sort(list);
	       return list.get(k-1);
	    }
	
	public static long kthElementChat(int k, int arr1[], int arr2[]) {
	       int n1 = arr1.length;
	        int n2 = arr2.length;

	        // Ensure arr1 is the smaller array
	        if (n1 > n2) {
	            return kthElementChat(k,arr2, arr1);
	        }

	        int low = Math.max(0, k - n2);
	        int high = Math.min(n1, k);

	        while (low <= high) {
	            int partition1 = (low + high) / 2;
	            int partition2 = k - partition1;

	            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
	            int minRight1 = (partition1 == n1) ? Integer.MAX_VALUE : arr1[partition1];

	            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
	            int minRight2 = (partition2 == n2) ? Integer.MAX_VALUE : arr2[partition2];

	            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
	                return Math.max(maxLeft1, maxLeft2);
	            } else if (maxLeft1 > minRight2) {
	                high = partition1 - 1;
	            } else {
	                low = partition1 + 1;
	            }
	        }
	        
	        return 0;
	    }
}
