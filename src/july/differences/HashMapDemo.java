package july.differences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapDemo {
	 public static void main(String args[]){    
	      //HashMap implementation  
	         HashMap<Integer,String> m=new HashMap<Integer,String>();//Creating HashMap      
	       m.put(1,"Chris");  //Adding elements in Map    
	       m.put(2,"Morris");      
	       m.put(3,"Sam");     
	       m.put(4,"Cruise");   
	       m.put(5,"Sam");     
	       m.put(6,"Cruise"); 
	       System.out.println("Iterating Hashmap...");    
	       for (Iterator<Entry<Integer, String>> iterator = m.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, String> me = iterator.next();
			System.out.println(me.getKey()+" "+me.getValue());
		}    
	    }    
}
