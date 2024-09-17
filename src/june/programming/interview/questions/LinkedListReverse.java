package june.programming.interview.questions;

import java.util.LinkedList;

public class LinkedListReverse {

	public static void main(String[] args) {
		LinkedList<Integer> ll =  new  LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		System.out.println(ll);
		
		LinkedList<Integer> ll1 =  new LinkedList<Integer>();
		ll.descendingIterator().forEachRemaining(ll1::add);
		System.out.println(ll1);
	}
}
