package june;

public class MyAtoiClass {
	 public int myAtoi(String s) {
	        int index = 0, n = s.length();
	        // Step 1: Ignore leading whitespaces
	        while (index < n && s.charAt(index) == ' ') {
	            index++;
	        }
	        
	        // Step 2: Determine the sign
	        int sign = 1;
	        if (index < n && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
	            sign = s.charAt(index) == '-' ? -1 : 1;
	            index++;
	        }
	        
	        // Step 3: Convert the number
	        int result = 0;
	        while (index < n && Character.isDigit(s.charAt(index))) {
	            int digit = s.charAt(index) - '0';
	            
	            // Step 4: Check for overflow
	            if (result > (Integer.MAX_VALUE - digit) / 10) {
	                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            }
	            
	            result = result * 10 + digit;
	            index++;
	        }
	        
	        return result * sign;
	    }
	    
	    public static void main(String[] args) {
	    	MyAtoiClass solution = new MyAtoiClass();
	        
	        // Test cases
	        System.out.println(solution.myAtoi("42"));           // Output: 42
	        System.out.println(solution.myAtoi("   -042"));      // Output: -42
	        System.out.println(solution.myAtoi("1337c0d3"));     // Output: 1337
	        System.out.println(solution.myAtoi("0-1"));          // Output: 0
	        System.out.println(solution.myAtoi("words and 987"));// Output: 0
	    }
}
