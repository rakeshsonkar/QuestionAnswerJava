package june;

import java.util.Scanner;

public class Bits {
	public static void main(String[] args) {
		// get bit
		int n=5;
		int pos=3;
		int bitMask = 1<<pos;
		
		if((bitMask&n)==0) {
			System.out.println("bit was zero");
		}else {
			System.out.println("bit was one");
		}
		
		// Set bit => Set the 2nd bit(position =1) of a number n. (n=0101)
		// Bit Mask : 1<< i    Operation : OR \\
		
		int n1=5;
		int pos1=1;
		int bitMask1 = 1<<pos1;
		int newNumber=bitMask1 | n1;
		System.out.println(newNumber);
		
		// Clear Bit => Clear the 3rd bit (position = 2) of a number n.(n=0101)
		// bit mask : 1<<i   
		// Operation : AND with Not  1<<2 => 0001 << 2 = 0100 BM   
		// ~(0100) => 1011  
		
		
		int n2= 5;
		int pos2=2;
		int bitMask2 = 1<< pos2;
		int notBitMask= ~(bitMask2);
		int newNumber2= notBitMask & n2;
		System.out.println(newNumber2);
		
		
	// Update Bit 
	// Update the 2nd bit (postion = 1) of a number n to 1.(n=0101)
	// For 0  or  clear
	// Bit Mask : 1<<i   
	// Operation 
		
	try (// For 1 
		Scanner sc = new Scanner(System.in)) {
			int oper = sc.nextInt();
			@SuppressWarnings("unused")
			int m=5;
			int po=1;	
			//int oper=1;
			int bitMaskU=1<<po;
			if(oper==1) {
				// set opreation 
			
				int newNumberU=bitMaskU|n;
				System.out.println(newNumberU);
			}else {
				// clear 
				
				@SuppressWarnings("unused")
				int newBitMaskU= ~(bitMaskU);
				int newNumberU =bitMaskU & n;
				System.out.println(newNumberU);
			}
		}
		
	
	}
}
