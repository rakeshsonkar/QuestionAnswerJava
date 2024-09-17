package july;

import java.util.Arrays;

public class LongestAlternatingSubsequence {

	public static void main(String[] args) {
		 int [] arr= {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
		 
		 System.out.println(alternatingMaxLength(arr));
		 System.out.println(alternatingMaxLength1(arr));
	}

	private static int alternatingMaxLength(int[] arr) {
		// TODO Auto-generated method stub
		
		int n=arr.length;
		int[] [] dp = new int[n][2];
		for(int[] row : dp) {
			Arrays.fill(row, 1);
		}
		int ans = 0;
		for (int i = 0; i <n; i++) {
			for (int j = i-1; j >=0; j--) {
				if(arr[j] < arr[i] && 1+dp[j][1] >dp[i][0]) {
					dp[i][0] =1+dp[j][1];
				}else if(arr[j] >arr[i] && 1+dp[j][0] > dp[i][1]) {
					dp[i][1]=1+dp[j][0];
				}
			}
			ans = Math.max(ans,Math.max(dp[i][0] , dp[i][1]));
		}
		return ans;
	}
	
	private static int alternatingMaxLength1(int[] arr) {
		 // code here
        int up = 1;
        int down = 1;
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i + 1] - arr[i] > 0)
                up = down + 1;
            else if (arr[i + 1] - arr[i] < 0)
                down = up + 1;
            i++;
        }
        if (up > down)
            return up;
        else
            return down;
    
	}
}
