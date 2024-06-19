package june;

import java.util.TreeSet;

public class TreeSetExample {
	
	public static void main(String[] args) {
		TreeSet<String> a = new  TreeSet<String>();
		a.add("A");
		a.add("a");
		a.add("Z");
		a.add("F");
		a.add("U");
		a.add("u");
		//a.add(null);
		System.out.println(a);
		
		TreeSet<Object> tSet= new TreeSet<Object>();
		tSet.add(new StringBuffer("A"));
		tSet.add(new StringBuffer("L"));
		tSet.add(new StringBuffer("D"));
		tSet.add(new StringBuffer("B"));
		System.out.println(tSet);
		System.out.println("A".compareTo("Z"));
		System.out.println("Z".compareTo("B"));
		System.out.println("A".compareTo("A"));
		System.out.println("A".compareTo(null));
		
	}

}
