package june;

public class FractionComparator {

	public static String compareFractions(String str) {
        // Split the input string to get the two fractions
        String[] fractions = str.split(", ");
        
        // Extract numerator and denominator for the first fraction
        String[] fraction1 = fractions[0].split("/");
        int a = Integer.parseInt(fraction1[0]);
        int b = Integer.parseInt(fraction1[1]);
        
        // Extract numerator and denominator for the second fraction
        String[] fraction2 = fractions[1].split("/");
        int c = Integer.parseInt(fraction2[0]);
        int d = Integer.parseInt(fraction2[1]);
        
        // Calculate the cross products to compare fractions without floating-point arithmetic
        int lhs = a * d; // left-hand side of the comparison (a/b > c/d is equivalent to a*d > b*c)
        int rhs = b * c; // right-hand side of the comparison
        
        // Compare the fractions
        if (lhs > rhs) {
            return fractions[0];
        } else if (lhs < rhs) {
            return fractions[1];
        } else {
            return "equal";
        }
    }

    public static void main(String[] args) {
        // Test cases
        String str1 = "5/6, 11/45";
        String str2 = "8/1, 8/1";
        String str3 = "10/17, 9/10";

        System.out.println(compareFractions(str1)); // Output: 5/6
        System.out.println(compareFractions(str2)); // Output: equal
        System.out.println(compareFractions(str3)); // Output: 9/10
    }
}
