package june.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LearnSet {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>(); // o(1)
		set.add(10);
		set.add(50);
		set.add(90);
		set.add(30);
		set.add(20);
		set.remove(10);
		System.out.println(set);
		Set<Integer> set1 = new LinkedHashSet<Integer>(); // o(n)
		set1.add(10);
		set1.add(50);
		set1.add(90);
		set1.add(30);
		set1.add(20);
		// set1.remove(10);
		System.out.println(set1);
		// TreeSet
		Set<Integer> set2 = new TreeSet<Integer>();// o(logn)
		set2.add(10);
		set2.add(50);
		set2.add(90);
		set2.add(30);
		set2.add(20);
		// set1.remove(10);
		System.out.println(set2.contains(10));
		System.out.println(set2);

		// ENUM SET
		System.out.println(Color.GREEN);
		//EnumSet<Color> enumSet=EnumSet.allOf(Color.class);
	}

	enum Color {
		RED, YELLOW, GREEN
	}

}
