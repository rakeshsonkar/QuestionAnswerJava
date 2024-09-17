package aug.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import june.PalindromeFinder;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CheckFailFast {

	public static void main(String[] args) {
		
		Map<String,String> map = new ConcurrentHashMap<String,String>();
		map.put("Ambar","Gupta");
		map.put("Shivangi","Gupta");
		map.put("Aarav","Gupta");
		map.put("Anukriti","Gupta");
        map.put("SomeOne","Else");

		Iterator<String> it1 = map.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			if (key.equals("SomeOne") || key.startsWith("A")) {
				map.remove(key);
			} else {
				System.out.println(" Name is " + key);
			}
		}
	
		
		/*
		 * Map<String,String> mp= new LinkedHashMap<String, String>(); mp.put(null,
		 * "null"); mp.put(null, ""); mp.put("1", null); mp.put("2", null);
		 */
 		
		/*
		 * Hashtable<Integer, String> hs= new Hashtable<Integer, String>(); hs.put(,"");
		 * hs.put(1, "r"); hs.put(2, "ss");
		 */
		
		
		//System.out.println(mp);
		
		
		Set<String> setOfName = new LinkedHashSet<>();
		setOfName.add("Ambar");
		setOfName.add("Shivangi");
		setOfName.add("Aarav");
		setOfName.add("Anukriti");
		setOfName.add("Anukriti");
		setOfName.add("Anukriti");
		setOfName.add("Anukriti");
		setOfName.add(null);
		System.out.println(setOfName);
		
		
		Iterator<String> it = setOfName.iterator();
		while (it.hasNext()) {
			String key =  it.next();
			if (key.equals("Ambar")) {
				setOfName.remove(key);
			} else {
				System.out.println(" Name is " + key);
			}
		}
		
		
		
	}
}
