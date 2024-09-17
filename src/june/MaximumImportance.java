package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumImportance {
	 public static long maximumImportance(int n, int[][] roads) {
	        long[] degree = new long[n];

	        for (int[] edge : roads) {
	            degree[edge[0]]++;
	            degree[edge[1]]++;
	        }

	        Arrays.sort(degree);

	        long value = 1;
	        long totalImportance = 0;
	        for (long d : degree) {
	            totalImportance += (value * d);
	            value++;
	        }

	        return totalImportance;
	    }
	 
	 public static long maximumImportance2(int n, int[][] roads) {
         // Create an array to store the degree (number of connections) of each city
        int[] degree = new int[n];
        
        // Calculate the degree of each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        // Create a list of cities and their degrees
        List<int[]> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cities.add(new int[]{i, degree[i]});
        }
        
        // Sort the cities by their degrees in descending order
        cities.sort((a, b) -> b[1] - a[1]);
        
        // Assign the highest values to the cities with the highest degrees
        int[] value = new int[n];
        int currentValue = n;
        for (int[] city : cities) {
            value[city[0]] = currentValue--;
        }
        
        // Calculate the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += value[road[0]] + value[road[1]];
        }
        
        return totalImportance;
    }
	 
	 public static void main(String[] args) {
		 int n1 = 5;
	        int[][] roads1 = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
	        System.out.println(maximumImportance(n1, roads1)); // Output: 43

	        int n2 = 5;
	        int[][] roads2 = {{0, 3}, {2, 4}, {1, 3}};
	        System.out.println(maximumImportance2(n2, roads2)); // Output: 20
	}
}
