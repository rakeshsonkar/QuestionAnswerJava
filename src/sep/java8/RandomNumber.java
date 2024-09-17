package sep.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random random = new Random();

		random.ints().limit(10).forEach(System.out::println);
		
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();

		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println(stats);
	}
}
