package june.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LearnMap {
	public static void main(String[] args) {
		// Map => HashMap => TreeMap => EnumMap => LinkedHashMap => WeakHashMap
		
		// the Map Integerface
		// In Java, elements of Map are stored in Key/Value pairs. Keys are unique values associated with individual Values
		// A map cannot contain duplicate keys. And ,Each key is associated with a single value.
		
		ArrayList<Integer> ls= new ArrayList<>();
		
		Map<String, String> map= new HashMap<String, String>();
		
		map.put("us", "United States");
		map.put("in", "India");
		map.putIfAbsent("in", "India2");
		map.put("en", "India");
		/*
		 * map.remove("us","United States"); System.out.println(map.containsKey("in"));
		 * System.out.println(map.containsValue("India2")); System.out.println(map);
		 * System.out.println(map.get("en"));
		 * System.out.println(map.getOrDefault("us","Others"));
		 */
		
		Set<String> keys= map.keySet();
		System.out.println(keys);
		Set<String> value= (Set<String>) map.values();
		System.out.println(value);
	}
}
