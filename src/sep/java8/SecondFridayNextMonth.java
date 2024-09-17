package sep.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class SecondFridayNextMonth {

	public static void main(String[] args) {
			Date date1 = new Date();
			System.out.println(date1.getYear());
			System.out.println(date1.getMonth());
		
		LocalDate firstInYear = LocalDate.of(date1.getYear(),date1.getMonth(), 1);

		LocalDate secondFriday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

		System.out.println("Second Friday on : " + secondFriday);
		
		// Lambda expression
		List<String> names = Arrays.asList("John", "Alice", "Bob");
		names.forEach(s -> System.out.println(s));

		// Method reference
		List<String> names1 = Arrays.asList("John", "Alice", "Bob");
		names1.forEach(System.out::println);
		
		
		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		System.out.println(st.limit(3).map(str -> str + "y"));

	}

}
