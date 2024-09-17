package june.programming.interview.questions;

public class FactorialRecursion {
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}

	public static long factorial(long n) {
		if(n==1)
			return 1;
		else
			return (n * factorial(n-1));
	}
}
