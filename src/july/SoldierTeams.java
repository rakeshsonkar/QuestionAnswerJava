package july;

public class SoldierTeams {

	 public static int numTeams(int[] rating) {
	        int n = rating.length;
	        int count = 0;

	        // Loop through each possible middle soldier j
	        for (int j = 1; j < n - 1; j++) {
	            int leftLess = 0, leftGreater = 0;
	            int rightLess = 0, rightGreater = 0;

	            // Count soldiers on the left of j
	            for (int i = 0; i < j; i++) {
	                if (rating[i] < rating[j]) {
	                    leftLess++;
	                } else if (rating[i] > rating[j]) {
	                    leftGreater++;
	                }
	            }

	            // Count soldiers on the right of j
	            for (int k = j + 1; k < n; k++) {
	                if (rating[k] < rating[j]) {
	                    rightLess++;
	                } else if (rating[k] > rating[j]) {
	                    rightGreater++;
	                }
	            }

	            // For each middle soldier j, calculate the valid teams
	            count += leftLess * rightGreater + leftGreater * rightLess;
	        }

	        return count;
	    }

	 
	 public static void main(String[] args) {
		 int[] rating1 = {2, 5, 3, 4, 1};
	        int[] rating2 = {2, 1, 3};
	        int[] rating3 = {1, 2, 3, 4};

	        System.out.println(numTeams(rating1)); // Output: 3
	        System.out.println(numTeams(rating2)); // Output: 0
	        System.out.println(numTeams(rating3)); // Output: 4
	}
}
