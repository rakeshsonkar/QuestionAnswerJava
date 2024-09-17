package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		
		List<Integer> sublist=list.subList(1, 3);
		sublist.clear();
		System.out.println(list);
		System.out.println(sublist);
	}
}
