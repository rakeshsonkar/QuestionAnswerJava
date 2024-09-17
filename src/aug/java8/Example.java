package aug.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		
		//filter methods 
		List<Integer> num= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> resultList = num.stream().filter(n->n>5).collect(Collectors.toList());
		System.out.println(resultList);
		
		//map methods
		List<String> words= Arrays.asList("apple","banana","cherray");
		List<String> toList =words.stream().map(d->d.toUpperCase()).toList();
		
		System.out.println(toList);
		
		// FlatMap
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("one","two"), Arrays.asList("three","four"),
				Arrays.asList("six")
				
				);
		List<String> res=listOfLists.stream().flatMap(Collection::stream).toList();
		System.out.println(res);
		
		//distinct 
		List<Integer> num1= Arrays.asList(1,2,3,4,5,6,7,8,9,10,5,4,2,6,7);
		System.out.println(num1.stream().distinct().toList());
		
		System.out.println(num1.stream().collect(Collectors.toUnmodifiableList()));
	}

}