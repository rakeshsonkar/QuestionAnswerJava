package collectionexample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Vector;

public class ArrayListExample {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		l.add("a");
		l.add(10);
		l.add(null);
		 System.out.println(l);
		 
		l.remove(2);
		System.out.println(l);
		l.add(2,"m");
		l.add("l");
		System.out.println(l);
		
		
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		
		System.out.println(al instanceof Serializable);
		System.out.println(ll instanceof Cloneable);
		System.out.println(al instanceof RandomAccess);
		System.out.println(ll instanceof RandomAccess);
		
		//Synchronized
		List check = Collections.synchronizedList(l);
		System.out.println(check);
		
		Vector vs= new Vector();
		for(int i=0; i<=10;i++) {
			vs.addElement(i);
		}
		Enumeration e = vs.elements();
		while (e.hasMoreElements()) {
			Integer i = (Integer) e.nextElement();
			if(i%2==0)
				System.out.println(i);
			
		}
		
	
		//System.out.println(vs);
	}
}
