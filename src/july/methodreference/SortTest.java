package july.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		/*
		 * ISort iSort = (list)->{ Collections.sort(list); };
		 */
		ISort iSort=Collections::sort;
		
		List<Integer> list1=Arrays.asList(8,1,7,3,2,5,7,4,6,10,9);
		iSort.sortAList(list1);
		System.out.println(list1);
	}
}
