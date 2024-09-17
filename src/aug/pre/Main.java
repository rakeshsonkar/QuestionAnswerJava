package aug.pre;

import java.util.ArrayList;
import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		Optional<String> optionalName = Optional.ofNullable("John");

		// Check if value is present
		if (optionalName.isPresent()) {
		    System.out.println("Name is present: " + optionalName.get());
		} else {
		    System.out.println("Name is not present");
		}
		
		// Creating Optional objects
        Optional<String> opt1 = Optional.of("Sweta");
        Optional<String> opt2 = Optional.of("Sweta");
        Optional<String> opt3 = Optional.of("Dash");

        // Comparing Optional objects
        System.out.println(opt1.equals(opt2));   // true
        System.out.println(opt1.equals(opt3));   // false
       
        MyFunctionalInterface myLambda =()->{
        	System.out.println("Hello word");
        };
        
        myLambda.myMethod();  
        
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        numbers.forEach(num->System.out.println(num));
        
        
	}

}
