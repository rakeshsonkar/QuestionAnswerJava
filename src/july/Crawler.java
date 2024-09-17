package july;

import java.util.Stack;

public class Crawler {

	public static void main(String[] args) {
		String[] logs1={"d1/","d2/","../","d21/","./"};
		String[] logs2={"d1/","d2/","./","d3/","../","d31/"};
		System.out.println(minOperations(logs1));
		System.out.println(minOperations1(logs2));
		System.out.println(minOperationsUsingStack(logs2));
	}
	
	public static int minOperations(String[] logs) {
        int depth=0;
        for(int i=0;i<logs.length;i++){
            if(logs[i] == "../"){
                if(depth !=0){
                depth--;
                }  
            }else if(logs[i] == "./"){
               continue;
            }else{
                depth++;
            }
        }
        return depth;
    }
	
	 public static int minOperations1(String[] logs) {
	        int depth = 0;
	        for (String log : logs) {
	            if (log.equals("../")) {
	                if (depth > 0) {
	                    depth--;
	                }
	            } else if (!log.equals("./")) {
	                depth++;
	            }
	        }
	        return depth;
	    }
	 
	 public static int minOperationsUsingStack(String[] logs) {
	        Stack<String> st= new  Stack<String>();
	        
	        for (String log : logs) {
	            if (log.equals("../")) {
	                if (!st.empty()) {
	                    st.pop();
	                }
	            } else if (!log.equals("./")) {
	               st.push(log);
	            }
	        }
	        return st.size();
	    }
}
