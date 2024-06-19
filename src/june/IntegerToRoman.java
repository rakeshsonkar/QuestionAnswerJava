package june;

public class IntegerToRoman {
	 public static String intToRoman(int num) {
	        // Define the mappings of Roman symbols and their corresponding values
	        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	        // Initialize a StringBuilder to construct the Roman numeral
	        StringBuilder roman = new StringBuilder();

	        // Loop through each value and symbol pair
	        for (int i = 0; i < values.length && num > 0; i++) {
	            // While the current value can be subtracted from num
	            while (num >= values[i]) {
	                // Append the corresponding symbol to the result
	                roman.append(symbols[i]);
	                // Subtract the value from num
	                num -= values[i];
	            }
	        }

	        // Convert the StringBuilder to a string and return it
	        return roman.toString();
	    }

	    public static void main(String[] args) {
	        // Test examples
	        System.out.println(intToRoman(3749)); // Output: MMMDCCXLIX
	        System.out.println(intToRoman(58));   // Output: LVIII
	        System.out.println(intToRoman(1994)); // Output: MCMXCIV
	    }
}
