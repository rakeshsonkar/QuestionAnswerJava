package aug;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "geek", str2 = "gesek"; 
		System.out.println(editDistance(str1,str2));
	}

	private static int editDistance(String str1, String str2) {
		
			int n=str1.length();
			int m=str2.length();
	       int[][] dp= new int[n+1][m+1];
	       for(int[] arr:dp){
	           Arrays.fill(arr,-1);
	       }
	     return  calculate(str1,str2,n,m,dp);
	}
	
	 public static int calculate(String str1, String str2, int n,int m,int[][] dp){
	        if(n==0){
	            return m;
	        }
	        if(m==0){
	             return n; 
	        }
	        
	        if(dp[n][m] != -1){
	           return dp[n][m];
	        }
	        
	        if(str1.charAt(n-1)==str2.charAt(m-1)){
	            return dp[n][m]= calculate(str1,str2,n-1,m-1,dp);
	        }
	        
	        return dp[n][m]= Math.min(calculate(str1,str2,n,m-1,dp)+1, Math.min(calculate(str1,str2,n-1,m,dp)+1 , calculate(str1,str2,n-1,m-1,dp)+1));
	    }
}
