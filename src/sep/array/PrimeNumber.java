package sep.array;

import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrime(91));
		System.out.println(isPrime1(9));
		System.out.println(isPrime(7));
		int[] numbers = {3, 4,13, 5, 16, 7,17, 18}; // Example array
        checkPrimesInArray(numbers);
		

	}
	
	public static boolean isPrime(int x) {
		int res = 0;
		for(int i=1;i < x/2; i++) {
			if(x % i == 0) {
				res++;
			}
		}
		return res == 1;
	}
	
	public static boolean isPrime1(int x) {
        return IntStream.range(1, x / 2)
                        .filter(i -> x % i == 0)
                        .count() == 1;
    }
	
	 public static boolean isPrime2(int x) {
	        if (x < 2) {
	            return false;
	        }
	        return IntStream.rangeClosed(2, (int) Math.sqrt(x)) // Check divisors up to sqrt(x)
	                        .noneMatch(i -> x % i == 0);       // Ensure no divisors in this range
	    }
	 
	 public static void checkPrimesInArray(int[] arr) {
	        IntStream.of(arr)
	                 .forEach(num -> {
	                     if (isPrime4(num)) {
	                         System.out.println(num + " is prime.");
	                     } else {
	                         System.out.println(num + " is not prime.");
	                     }
	                 });
	    }
	 
	 public static boolean isPrime4(int x) {
		    if (x <= 1) {
		        return false; // Numbers less than or equal to 1 are not prime
		    }
		    // Start checking from 2 up to sqrt(x)
		    for (int i = 2; i <= x / 2; i++) {
		        if (x % i == 0) {
		            return false; // If divisible by any number other than 1 and itself, it's not prime
		        }
		    }
		    return true; // If no divisors found, it's prime
		}

}
