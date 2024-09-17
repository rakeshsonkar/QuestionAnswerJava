package june.swap;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		// A palindrome number is a number that remains the same when its digits are reversed.Like 16461
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		int org_num=num;
		
		int rev=0;
		while(num!=0) {
			rev=rev*10+num%10;
			num=num/10;
			
		}
		if(org_num==rev) {
			System.out.println(" Palindrome number");
		}else {
			System.out.println("Not Palindrome number");
		}
		
	}
}
