package aug.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnmodifiableListExample {
	public static void main(String[] args) {
		Stream<String> cityStream = Stream.of("Mumbai","Delhi","Bengaluru","Chennai");
		
		List<String> cityList= cityStream.collect(Collectors.toUnmodifiableList());
		
		System.out.println("Unmofible List" +cityList);
		
		try {
			cityList.add("jaipur");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
