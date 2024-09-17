package july;

import java.util.LinkedList;
import java.util.List;

public class MaximumGain {
	
	public static void main(String[] args) {
		
	 System.out.println(maximumGain( "cdbcbbaaabab",5,4));	
	}
	
	 public static int maximumGain(String s, int x, int y) {
		 int res = 0;
	        LinkedList<Character> stack = new LinkedList<Character>();
	        String goodVal = x > y ? "ab" : "ba";
	        int small = Math.min(x, y);
	        int big = Math.max(x, y);

	        for (char c : s.toCharArray()) {
	            if (c > 'b') {
	                res += calculateRemainingStack(stack, small);
	                stack.clear();
	            } else if (!stack.isEmpty() && c == goodVal.charAt(1) && stack.getLast() == goodVal.charAt(0)) {
	                stack.removeLast();
	                res += big;
	            } else {
	                stack.add(c);
	            }
	        }

	        if (!stack.isEmpty()) {
	            res += calculateRemainingStack(stack, small);
	        }
	        return res;
	    }


	    private static int calculateRemainingStack(List<Character> stack,int small){
	        int ays=0;
	        int bees=0;
	        for(char c:stack){
	            if(c=='a'){
	                ays++;
	            }else {
	                bees++;
	            }
	        }
	        return Math.min(ays,bees)*small;
	    }

}
