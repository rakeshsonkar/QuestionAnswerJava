package june;

public class RemoveDuplicatesII {
	 public int removeDuplicates(int[] nums) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        int j = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (j < 2 || nums[i] != nums[j - 2]) {
	                nums[j] = nums[i];
	                j++;
	            }
	        }
	        return j;
	    }
	    public static void main(String[] args) {
	    	RemoveDuplicatesII solution = new RemoveDuplicatesII();    
	        int[] nums1 = {1, 1, 1, 2, 2, 3};
	        int k1 = solution.removeDuplicates(nums1);
	        System.out.print("Output: " + k1 + ", nums = [");
	        for (int i = 0; i < k1; i++) {
	            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
	        }
	        System.out.println("]");
	        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
	        int k2 = solution.removeDuplicates(nums2);
	        System.out.print("Output: " + k2 + ", nums = [");
	        for (int i = 0; i < k2; i++) {
	            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
	        }
	        System.out.println("]");
	    }
}
