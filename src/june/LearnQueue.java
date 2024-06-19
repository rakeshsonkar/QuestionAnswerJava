package june;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LearnQueue {
	public static void main(String[] args) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		q.offer(70);
		/*
		 * System.out.println(q); System.out.println(q.poll()); System.out.println(q);
		 * System.out.println(q.peek()); System.out.println(q);
		 */
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		ArrayDeque<Integer> ad= new ArrayDeque<Integer>();
		ad.offer(10);
		ad.offerLast(20);
		ad.offerFirst(30);
		System.out.println(ad);
		
		//stack
		ArrayDeque<Integer> stack= new ArrayDeque<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack.peek());
		
		// Queue
		ArrayDeque<Integer> queue= new ArrayDeque<Integer>();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		System.out.println(queue);
		System.out.println(queue.poll());
		
		
		
	}
	

}
