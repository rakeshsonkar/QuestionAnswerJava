package aug;

import java.util.PriorityQueue;

public class KthLargest {
	PriorityQueue<Integer> heap;
	int K;
	public KthLargest(int k,int[] nums) {
		heap = new PriorityQueue<Integer>();
		K=k;
		for (int num:nums) {
			add(num);
		}
	}
	public int add(int val) {
		if(heap.size() < K || heap.peek() < val) {
			heap.add(val);
			if(heap.size()>K) {
				heap.poll();
			}
		}
		return heap.peek();
	}
	
	
	

}
