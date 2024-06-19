package june;

public class ArmstrongNumber {
	 public static String isArmstrong(int n) {
	        // Extract the digits
	        int hundreds = n / 100;
	        int tens = (n / 10) % 10;
	        int units = n % 10;

	        // Calculate the sum of the cubes of the digits
	        int sumOfCubes = (hundreds * hundreds * hundreds) + 
	                         (tens * tens * tens) + 
	                         (units * units * units);

	        // Check if the sum of the cubes is equal to the number
	        if (sumOfCubes == n) {
	            return "true";
	        } else {
	            return "false";
	        }
	    }

	    public static void main(String[] args) {
	        // Test cases
	        int n1 = 153;
	        int n2 = 372;
	        
	        System.out.println(isArmstrong(n1)); // "true"
	        System.out.println(isArmstrong(n2)); // "false"
	    }
}
