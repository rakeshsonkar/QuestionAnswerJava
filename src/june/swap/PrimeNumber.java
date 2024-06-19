package june.swap;

import java.util.stream.IntStream;

public class PrimeNumber {
public static void main(String[] args) {
	int num=6;
	int count=0;
	if(num>1) {
		for(int i=1;i<=num;i++) {
			
			if(num%i == 0) {
				count++;
			}
					
		}
		
		if(count==2) {
			System.out.println("Prime Number");
		}else {
			System.out.println("Not Prime Number");
		}
	}else {
		System.out.println("Not Prime Number");
	}
	System.out.println("matherrejxhsgbcxvhlkc   ");
	 boolean isPrime = num > 1 && 
	            IntStream.rangeClosed(2, (int) Math.sqrt(num))
	                     .noneMatch(i -> num % i == 0);
	 
	 IntStream.rangeClosed(1, 100)
	 .filter(num1 -> num1 > 1
			 && IntStream.rangeClosed(2, (int) Math.sqrt(num1))
			 .noneMatch(i -> num1 % i == 0))
	 .forEach(System.out::println);
}
}
