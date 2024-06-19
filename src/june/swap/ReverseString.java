package june.swap;

public class ReverseString {
 
	public static void main(String[] args) {
		// 1)  ways  Using + (string concatenation) operator
		String str="ABCD";
		String rev= "";
		 int len =str.length();
		 for (int i = len-1; i >=0; i--) {
			rev = rev + str.charAt(i);
		}
		 System.out.println(rev);
		
		 // 2. Using character array
		 String rev2="";
		 char a[] = str.toCharArray();
		 
		 for (int i = a.length-1; i >= 0; i--) {
			 rev2 +=a[i];
		}
		 System.out.println( rev2); 
		 
		 // 3 ways  Using Buffer class
		 StringBuffer sb = new StringBuffer(rev2);
		 System.out.println(sb.reverse());
		 
	}
}
