package sep.infobook;
import java.util.UUID; 
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils; 


public class RandomStringGenerator {
	/*
	 * private static final Logger logger =
	 * Logger.getLogger(StringReplace.class.getName());
	 */
	public static void main(String[] args) {
		 //generating random alphanumeric String in Java using Apache commons 
        String random = RandomStringUtils.randomAlphanumeric(10);
 
        System.out.println("Random alphanumeric String in Java using commons RandomStringUtils      : " + random);
 
        System.out.println("Random numeric String generated in Java  : "+ RandomStringUtils.randomNumeric(10));
 
        System.out.println("Random alphabetic String in Java using created  by RandmomStringUtils    : " + RandomStringUtils.randomAlphabetic(10));
        
      //random String in Java using UUID class      
        random = UUID.randomUUID().toString(); 
        System.out.println("Random String generated in Java using UUID : " + random);

 
        //Java code to generate random alpha numeric String in Java with specified length
        random = randomString(10);
 
        System.out.println("Random alphanumeric String generated using Math.random() : " + random);
 
	}
	
	public static String randomString(int length){
		 
        char[] ALPHANUMERIC  ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
 
        StringBuilder random = new StringBuilder();
 
        for(int i =0; i < length; i++) {
            int index = (int) (Math.random()*ALPHANUMERIC.length);
            random.append(ALPHANUMERIC[index]);
        }
        return random.toString();
    }  
}
