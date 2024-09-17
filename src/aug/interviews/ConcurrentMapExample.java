package aug.interviews;

import java.util.concurrent.ConcurrentHashMap;



public class ConcurrentMapExample {

	public static void main(String[] args) {
		ConcurrentHashMap<String,Integer> concurrentMap = new  ConcurrentHashMap<String, Integer>();
		
		concurrentMap.put("one", 1);
		concurrentMap.put("two", 2);
		concurrentMap.put("three", 3);
		int value = concurrentMap.get("two");
		System.out.println(value);
	}
}
