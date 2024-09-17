package sep.array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
	public static void main(String[] args) {
		 Integer[] intArray = {10,20,30,40,50,60,70,80,90};
		 int [] intArray1 = {11,22,33,44,55,66,77,88,99};
		 System.out.println("Original Array:");
		 for(int i=0;i<intArray.length;i++)
	         System.out.print(intArray[i] + "  ");
		 
		 
		 
		 System.out.println();
		 reverse(intArray);
		 System.out.println();
		 reverseArray(intArray1,intArray1.length);
		
		    //print array starting from last element
		    System.out.println("Original Array printed in reverse order:");
		         for(int i=intArray.length-1;i>=0;i--)
		         System.out.print(intArray[i] + "  ");
		    
	}
	
	static void reverse(Integer myArray[]) 
    { 
        Collections.reverse(Arrays.asList(myArray)); 
        System.out.println("Reversed Array:" + Arrays.asList(myArray)); 
    }
	
	/*swap the first elemnt of array with the last element; second element with second last and so on*/
    static void reverseArray(int[] intArray1, int size) 
    { 
        int i, k, temp; 
        for (i = 0; i < size / 2; i++) { 
            temp = intArray1[i]; 
            intArray1[i] = intArray1[size - i - 1]; 
            intArray1[size - i - 1] = temp; 
        } 
 
        /*print the reversed array*/
       System.out.println("Reversed Array 	qre: \n" + Arrays.toString(intArray1)); 
    } 
	

}
