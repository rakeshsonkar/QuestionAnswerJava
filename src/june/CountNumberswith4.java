package june;

public class CountNumberswith4 {

	 public static void main(String[] args) {
	        System.out.println(countNumbersWithDigit4(9));   // Output: 1
	        System.out.println(countNumbersWithDigit4(44));  // Output: 9
	        System.out.println(countNumbersWithDigit4(100)); // Example larger number
	        
	        String str="Rakesh";
	        
	       System.out.println(str.concat("R"));
	        
	    }

	    public static int countNumbersWithDigit4(int n) {
	        int count = 0;
	        for (int i = 1; i <= n; i++) {
	            if (containsDigit4(i)) {
	                count += 1;
	            }
	        }
	        return count;
	    }

	    public static boolean containsDigit4(int number) {
	        String numStr = String.valueOf(number);
	        return numStr.contains("4");
	    }

}
