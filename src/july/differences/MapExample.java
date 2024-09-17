package july.differences;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<String , Integer> m = new  HashMap<String, Integer>();
		  m.put("Abhi",1); //Adding elements  
          m.put("Nick", 2);   
          m.put("Ketty",3);   
          m.put("Paul", 4);  
          m.put("Paul",5); 
          m.put("Paul1",4);  
          m.put("Paul2",5); 
			/*
			 * m.put("", new Integer(0)); m.put("", new Integer(1));
			 */
          
          for(Map.Entry<String, Integer> me : m.entrySet()) {
        	  System.out.print(me.getKey() + " ");
        	  System.out.println(me.getValue());
          }
	}
}
