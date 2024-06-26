package hiddenfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionHiddenMethods {

	public static void main(String[] args) {
		// Collection.nCopies()
		List<String> name = Collections.nCopies(5, "rakesh sonkar");
		System.out.println(name);

		try {
			name.set(0, "raj");
		} catch (UnsupportedOperationException e) {
			System.out.println("List is immutable , it can't be Modify");
		}

		// Collection.Frequency()
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 1, 2, 4, 5, 6, 7, 4, 3, 6, 1, 2, 6);
		long count = Collections.frequency(numbers, 1);
		System.out.println(count);

		// find occurrence of each element in given list
		Map<Integer, Integer> countMap = numbers.stream().collect(Collectors.toMap(number -> number,
				number -> Collections.frequency(numbers, number), (exitingValue, newValue) -> exitingValue));
		System.out.println(countMap);

		// Collections.disjoint()
		List<Integer> list1 = new ArrayList<>();
		Collections.addAll(list1, 1, 2, 3, 4, 5);

		List<Integer> list2 = new ArrayList<>();
		Collections.addAll(list2,  7, 8, 9, 10);

		boolean areDisjoint = Collections.disjoint(list1, list2);
		if(areDisjoint) {
			System.out.println("This list have no Common element");
		}else {
			System.out.println("This list have common element");
		}
		
		
		//collections.singleton
		
		Set<String> myCollection = Collections.singleton("rakeshSonkar");
		try {
			myCollection.add("Raj Data");
			
		}catch (UnsupportedOperationException e) {
			System.out.println("Set is immutable , it can't be Modify");
		}
		
		// Coolections.rotate()
		List<String> test= new ArrayList<String>();
		test.add("Test the issuse");
		test.add("this");
		test.add("use");
		System.out.println(test);
	}

}
