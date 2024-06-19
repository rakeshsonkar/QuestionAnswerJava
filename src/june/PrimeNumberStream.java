package june;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberStream {

	public static void main(String[] args) {
		  List<Integer> primes = generatePrimes(10);
	        primes.forEach(System.out::println);
	}
	
	public static List<Integer> generatePrimes(int limit) {
        return IntStream.iterate(2, i -> i + 1)
                        .filter(PrimeNumberStream::isPrime)
                        .limit(limit)
                        .boxed()
                        .collect(Collectors.toList());
    }
	// Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .allMatch(n -> number % n != 0);
    }
}
