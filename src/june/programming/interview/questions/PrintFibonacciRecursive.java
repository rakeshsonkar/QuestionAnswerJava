package june.programming.interview.questions;

public class PrintFibonacciRecursive {

	public static void main(String[] args) {
		int seqLength = 15;
		System.out.print("A Fibonacci sequence of " + seqLength + " numbers : ");
		for (int i = 0; i < seqLength; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}

	private static int fibonacci(int count) {
		// TODO Auto-generated method stub
		if (count <= 1)
			return count;

		return fibonacci(count - 1) + fibonacci(count - 2);
	}
}
