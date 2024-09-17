package june.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StartWith {

	public static void main(String[] args) {
		int [] numbers= {23,50,32,45,60,25,68,29,30};
		Arrays.stream(numbers).boxed().map(d->d+"").filter(d->d.startsWith("2")).collect(Collectors.toList()).forEach(System.out::println);
		
		String[] names= {"sumit","karan","GainJavaKnowlage","Vivek","Monty"};
		@SuppressWarnings("unused")
		String longetsString= Arrays.stream(names).max(Comparator.comparingInt(String::length)).get();
		String longetsStrings=Arrays.stream(names).reduce((x, y)->x.length()>y.length()?x:y).get();
		System.out.println("langet  "+longetsStrings);
		
		String str="gainJavaknowlage";
		
		Map<String, Long> t= Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		List<String> t2 =t.entrySet().stream().filter(d->d.getValue()>1).map(d->d.getKey()).toList();
		System.out.println(t2);
		
		Map<Character, Long> t3= str.chars().mapToObj( d -> (char) d).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(t3);
		
	}
}
