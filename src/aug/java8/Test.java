package aug.java8;

import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String... rakesh) {
		List<Integer> list= new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(1, 0);
		System.out.println(list);
	}
}
