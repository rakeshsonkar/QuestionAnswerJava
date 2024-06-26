package june;

public class Bookstore {
	  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
	        int n = customers.length;
	        
	        // Calculate the base number of satisfied customers without using the technique
	        int satisfiedCustomers = 0;
	        for (int i = 0; i < n; i++) {
	            if (grumpy[i] == 0) {
	                satisfiedCustomers += customers[i];
	            }
	        }
	        
	        // Calculate the additional satisfied customers when using the technique for the first window
	        int extraSatisfiedCustomers = 0;
	        for (int i = 0; i < minutes; i++) {
	            if (grumpy[i] == 1) {
	                extraSatisfiedCustomers += customers[i];
	            }
	        }
	        
	        int maxExtraSatisfiedCustomers = extraSatisfiedCustomers;
	        
	        // Use sliding window to find the maximum additional satisfied customers
	        for (int i = minutes; i < n; i++) {
	            if (grumpy[i] == 1) {
	                extraSatisfiedCustomers += customers[i];
	            }
	            if (grumpy[i - minutes] == 1) {
	                extraSatisfiedCustomers -= customers[i - minutes];
	            }
	            maxExtraSatisfiedCustomers = Math.max(maxExtraSatisfiedCustomers, extraSatisfiedCustomers);
	        }
	        
	        return satisfiedCustomers + maxExtraSatisfiedCustomers;
	    }

	    public static void main(String[] args) {
	        Bookstore bookstore = new Bookstore();
	        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
	        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
	        int minutes = 3;
	        System.out.println(bookstore.maxSatisfied(customers, grumpy, minutes)); // Output: 16
	    }
}
