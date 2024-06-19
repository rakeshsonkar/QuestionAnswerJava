package june.swap;

public class ReverseNumber {

	public static void main(String[] args) {
		//1 ways  Using algorithm
		int num=1234;
		
	int rev=0;
	while(num!=0) {
		rev=rev*10+num%10;
		num=num/10;
		}
	System.out.println(rev);
	num=1234;
	// 2 way  Using StringBuffer  Class
	StringBuffer sb = new StringBuffer(String.valueOf(num));
	StringBuffer rev2= sb.reverse();
	
	System.out.println(rev2);

	//3 way Using String Builder class
	StringBuilder sb2= new StringBuilder();
	sb2.append(rev2);
	sb2.reverse();
	
	System.out.println(sb2);
	
	}
}
