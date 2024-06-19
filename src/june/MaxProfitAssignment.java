package june;

import java.util.Arrays;

public class MaxProfitAssignment {
	 public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
	        int n = difficulty.length;
	        int[][] jobs = new int[n][2];
	        
	        for (int i = 0; i < n; i++) {
	            jobs[i][0] = difficulty[i];
	            jobs[i][1] = profit[i];
	        }
	        
	        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // Sort jobs by difficulty
	        Arrays.sort(worker); // Sort workers by ability
	        
	        int maxProfit = 0;
	        int totalProfit = 0;
	        int j = 0;
	        
	        for (int i = 0; i < worker.length; i++) {
	            while (j < n && jobs[j][0] <= worker[i]) {
	                maxProfit = Math.max(maxProfit, jobs[j][1]);
	                j++;
	            }
	            totalProfit += maxProfit;
	        }
	        
	        return totalProfit;
	    }

	    public static void main(String[] args) {
	    	MaxProfitAssignment solution = new MaxProfitAssignment();
	        
	        int[] difficulty1 = {2, 4, 6, 8, 10};
	        int[] profit1 = {10, 20, 30, 40, 50};
	        int[] worker1 = {4, 5, 6, 7};
	        System.out.println(solution.maxProfitAssignment(difficulty1, profit1, worker1)); // Output: 100
	        
	        int[] difficulty2 = {85, 47, 57};
	        int[] profit2 = {24, 66, 99};
	        int[] worker2 = {40, 25, 25};
	        System.out.println(solution.maxProfitAssignment(difficulty2, profit2, worker2)); // Output: 0
	    }
}
