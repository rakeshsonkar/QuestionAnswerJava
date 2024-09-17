package sep.question;

public class LongExample {
	public static void main(String[] args) {
        long amountInCents = 10;  // Representing 0.10 USD as 10 cents
        long totalInCents = amountInCents * 3;
        
        System.out.println("Result using long: " + totalInCents / 100.0 + " USD"); // Output: 0.3 USD
    }
}
