package june.swap;

public class LargestNumber {

	public static void main(String[] args) {
		int a=569;
		int b=75;
		int c=50;
		// 1 way 
		if(a>b&&a>c) {
			System.out.println(a);
		}else if(b>a && b>c) {
			System.out.println(b);
		}else {
			System.out.println(c);
		}
		
		
		// 2 way  Ternary Operator
		int largest=a>b?a:b;
		
		int largest2= c>largest?c:largest;
		
		System.out.println(largest2);
	}
}
