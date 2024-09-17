package sep.question;

import java.math.BigDecimal;

public class BigDecimalExample {
	 public static void main(String[] args) {
	        BigDecimal amount = new BigDecimal("0.1");
	        BigDecimal total = amount.multiply(new BigDecimal("3"));
	        
	        System.out.println("Result using BigDecimal: " + total); // Output: 0.3
	    }
}
