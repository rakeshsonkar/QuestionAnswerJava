package june.swap;

public class Swapping2Numbers {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		// 1 ways
		int c=a;
		a=b;
		b=c;
		// 2 ways
		a=a+b;
		b=a-b;
		a=a-b;
		// 3 ways
		// here a & b vales should not be Zero.
		a=a*b;
		b=a/b;
		a=a/b;
		
		// 4 ways 
		//bitwise XOR(^)
		a=a^b;
		b=a^b;
		a=a^b;
		// 5 ways
		b=a+b-(a=b);
		System.out.println(a +"  "+b);
	}
}
