package aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaintainSortedList {
	List<Integer> stream;
	int k;
	public MaintainSortedList(int k,int[] nums) {
		stream = new ArrayList<Integer>(nums.length);
		this.k=k;
		for(int num : nums) {
			stream.add(num);
		}
		
		Collections.sort(stream);
	}
	public  int  add(int val) {
		int index = getIndex(val);
		stream.add(index,val);
		return stream.get(stream.size() -k );
	}
	private int getIndex(int val) {
		// TODO Auto-generated method stub
		int left =0;
		int right= stream.size() -1;
		while(left <= right) {
			int mid=(left+right)/2;
			int midElement= stream.get(mid);
			if(midElement == val) return mid;
			if(midElement > val) {
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return left;
	}

}
