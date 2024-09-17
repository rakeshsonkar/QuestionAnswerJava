package july;

import java.util.Stack;

public class MinimumDeletion {
	public static void main(String[] args) {
		String str1="baababbab";
		System.out.println(minimumDeletions(str1));
		String str2="bbbaaaaabb";
		System.out.println(OptimizedDP(str2));
	}
	public static int minimumDeletions(String s) {
		
	       int totalA=0;
	       // count total a 
	        for(char ch:s.toCharArray()){
	            if(ch=='a') totalA++;
	        }

	        int minimumDeltetion = totalA;
	        int leftOfB =0;
	        int rightOfA = totalA;
	        for(char ch:s.toCharArray()){
	            if(ch=='a')rightOfA--;
	            else leftOfB++;

	            minimumDeltetion=Math.min(minimumDeltetion , leftOfB + rightOfA);
	        }
	        return minimumDeltetion;
	    }
	
	//Three Pass Count Method 
	public static int ThreePassCountMethod(String  s) {
		int n = s.length();
		int[] countA=new int[n];
		int[] countB = new int[n];
		int bCount=0;
		 // First pass: compute count_b which stores the number of
        // 'b' characters to the left of the current position.
		for(int i=0;i<n;i++) {
			countB[i] =bCount;
			if(s.charAt(i)=='b') bCount++;
		}
		int aCount =0;
		  // Second pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
	for (int i = n-1; i >= 0; i--) {
		countA[i]=aCount;
		if(s.charAt(i) =='a') aCount++;
	}
	
	int minDeletion=n;
	//Third pass: iterate through the string to find the minimum deletions
	for(int i=0;i<n;i++) {
		minDeletion = Math.min(minDeletion, countA[i]+countB[i]);
	}
		
		return minDeletion;
	}
	
	// Combined Pass Method 
	public static int combinedPassMethod(String s) {
		int n =s.length();
		int[] countA= new int[n];
		int aCount=0;
		// First pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
		for (int i = n-1; i >=0; i--) {
			countA[i] =aCount;
			if(s.charAt(i) == 'a') aCount++;
		}
		
		int minDeletions=n;
		int bCount=0;
		// Second pass: compute minimum deletions on the fly
		for (int i = 0; i < n; i++) {
			minDeletions=Math.min(countA[i]+bCount,minDeletions);
			if(s.charAt(i)=='b')bCount++;
		}
		
		return minDeletions;
	}
	
	// Two-Variable Method 
	
	public static int TwoVariableMethod(String s){
		int n=s.length();
		int aCount =0;
		
		// First  pass: count the number of 'a's
		for (int i = 0; i <n; i++) {
			if(s.charAt(i)=='a') aCount++;
		}
		
		int bCount =0;
		int minDeletions=n;
		 // Second pass: iterate through the string to compute minimum deletions
		for(int i=0;i<n;i++) {
			if(s.charAt(i) == 'a')aCount--;
			minDeletions=Math.min(minDeletions, aCount+bCount);
			if(s.charAt(i)=='b')bCount++;
		}
		
		return minDeletions;
	}
	/// Using stack (one pass)
	public static int UsingStackOnePass(String s) {
		int n=s.length();
		Stack<Character> charStack = new Stack<Character>();
		int deleteCount=0;
		 // Iterate through each character in the string
		for (int i = 0; i < n; i++) {
			// If stack is not empty, top of stack is 'b',
            // and current char is 'a'
			if(
					!charStack.isEmpty() && 
					charStack.peek()=='b' && 
					s.charAt(i)=='a'
					) {
				
				charStack.pop();//Remove 'b' from stack
				deleteCount++; // Increment deletion count
				
			}else {
				charStack.push(s.charAt(i));
			}
		}
		
		return deleteCount;
	}
	
	/// Using DP (One Pass)
	public static int UsingDPOnePass(String s) {
		int n=s.length();
		int[] dp=new int[n+1];
		int bCount=0;
		
		// dp[i]: The number of deletions required to
        // balance the substring s[0, i)
		for(int i=0;i<n; i++) {
			if(s.charAt(i)=='b') {
				dp[i+1]=dp[i];
				bCount++;
			}else {
				dp[i+1] = Math.min(dp[i], bCount);
			}
		}
		return dp[n];
	}
	
	//Optimized DP 
	
	public static int OptimizedDP(String s) {
		int n=s.length();
		int minDeletions=0;
		int bCount=0;
		
		 // minDeletions variable represents dp[i]
		 for (int i = 0; i < n; i++) {
	            if (s.charAt(i) == 'b') {
	                bCount++;
	            } else {
	                // Two cases: remove 'a' or keep 'a'
	                minDeletions = Math.min(minDeletions + 1, bCount);
	            }
	        }
		 
		 
		return minDeletions;
	}
}
