package sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
//		Integer a=128,b=128;
//		System.out.println(a==b);
//		System.out.println(a.equals(b));
//		Integer c=100,d=100;
//		System.out.println(c==d);
		List<String> listOfCities = new ArrayList<>
        (Arrays.asList(new String[]{"USD", "GBP", "INR"}));
		

for(String city : listOfCities){
  System.out.println(city);
}
	
	}

}
//false
//trueo	



