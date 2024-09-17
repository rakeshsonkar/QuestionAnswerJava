package aug;

import java.util.Arrays;

public class MinimumSwapstoGroupAll1sTogetherII {
	public static void main(String[] args) {
		int[] nums = {0,1,0,1,1,0,0};
		System.out.println(usingSuffixSum(nums));
		System.out.println(usingSlidingWindow(nums));
		System.out.println(cleanerAndMoreIntuitiveSlidingWindow(nums));
		System.out.println(minSwaps(nums));
	}

	private static int minSwaps(int[] nums) {
		// TODO Auto-generated method stub
		
		int n = nums.length;
		int totalOnes=Arrays.stream(nums).reduce(0,Integer::sum);
		int i=0;
		int j=0;
		int currOnes=0;
		int maxCount=0;
		while(j<2*n) {
			if(nums[j%n]==1) {
				currOnes++;
			}
			if(j-i+1 >totalOnes) {
				currOnes -=nums[i%n];
				i++;
			}
			maxCount=Math.max(maxCount, currOnes);
			j++;
		}
		
		return totalOnes-maxCount;
	}
	
	///  Approach 1: Using Suffix Sum 
	public static int usingSuffixSum(int[] nums) {
		// Calculate the minimum swaps needed to group all 1s or all 0s together
		int op1=minSwapHelper(nums,0); // Grouping all 0s together
		int op2=minSwapHelper(nums,1); // Grouping all 1s together
		return Math.min(op1, op2);
	}

	private static int minSwapHelper(int[] nums, int i) {
		int length = nums.length;
		int[] rightSuffixSum =  new int[length+1];
	      // Construct the suffix sum array for counting opposite values (val ^ 1)
		  for(int j=length-1;j>=0;j--) {
			  rightSuffixSum[j]=rightSuffixSum[j+1];
			  if(nums[j]==(i^1))rightSuffixSum[j]++;
		  }
		  
		  // Total zeros in the array if `val` is 1 (or vice versa)
		  int totalSwapsNeed= rightSuffixSum[0];
		  // Track current number of required swaps in the current segment
		  int currentSwapCount=0;
		  int minimumSwaps= totalSwapsNeed-rightSuffixSum[length-totalSwapsNeed];
		  // Iterate to find the minimum swaps by sliding the potential block of grouped `val`
		  for (int j = 0; j < totalSwapsNeed; j++) {
	            if (nums[j] == (i ^ 1)) currentSwapCount++;
	            int remaining = (totalSwapsNeed - j - 1);
	            int requiredSwaps =
	                ((j + 1) - currentSwapCount) +
	                (remaining - rightSuffixSum[length - remaining]);
	            minimumSwaps = Math.min(minimumSwaps, requiredSwaps);
	        }
	        return minimumSwaps;
	}
	
	//Approach 2: Using Sliding Window
	
	public static int usingSlidingWindow(int[] nums) {
		 // Calculate the minimum swaps needed to group all 1s or all 0s together
        int op1 = minSwapsHelper(nums, 0); // Grouping all 0s together
        int op2 = minSwapsHelper(nums, 1); // Grouping all 1s together
        return Math.min(op1, op2);
	}

	private static int minSwapsHelper(int[] nums, int i) {
		 int length = nums.length;
	        int totalValCount = 0;
	        
	        // Count the total number of `val` in the array
	        for (int j = length - 1; j >= 0; j--) {
	            if (nums[j] == i) totalValCount++;
	        } 
	        
	        // If there is no `val` or the array is full of `val`,
	        // no swaps are needed
	        if (totalValCount == 0 || totalValCount == length) return 0;
     
	        int start = 0, end = 0;
	        int maxValInWindow = 0, currentValInWindow = 0;

	        // Initial window setup: count the number of `val` in
	        // the first window of size `totalValCount`
	        while (end < totalValCount) {
	            if (nums[end++] == i) currentValInWindow++;
	        }
	        maxValInWindow = Math.max(maxValInWindow, currentValInWindow);
	        
	        // Slide the window across the array to find the
	        // maximum number of `val` in any window
	        while (end < length) {
	            if (nums[start++] == i) currentValInWindow--;
	            if (nums[end++] == i) currentValInWindow++;
	            maxValInWindow = Math.max(maxValInWindow, currentValInWindow);
	        }

	        // Minimum swaps are the total `val` minus
	        // the maximum found in any window
	        return totalValCount - maxValInWindow;
	}
	
	///Approach 3: Cleaner and More Intuitive Sliding Window
	
	private static int cleanerAndMoreIntuitiveSlidingWindow(int[] nums) {
		// Initialize minimum swaps to a large value
        int minimumSwaps = Integer.MAX_VALUE;
        
        // Calculate the total number of 1s in the array
        int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num;
        } 
        
        // Initialize the count of 1s in the current window
        int onesCount = nums[0];
        int end = 0;
        
        
        // Slide the window across the array
        for (int start = 0; start < nums.length; ++start) {
            // Adjust onesCount by removing the element that is sliding out of
            // the window
            if (start != 0) {
                onesCount -= nums[start - 1];
            }

            // Expand the window to the right until it reaches the desired size
            while (end - start + 1 < totalOnes) {
                end++;
                onesCount += nums[end % nums.length];
            }

            // Update the minimum number of swaps needed
            minimumSwaps = Math.min(minimumSwaps, totalOnes - onesCount);
        }

        return minimumSwaps;
        
		
	}
}
