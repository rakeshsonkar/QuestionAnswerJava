package june.swap;

public class NumberOfDigit {

	public static void main(String[] args) {
		int num=369987512;
		int count=0;
		while(num>0) {
			num=num/10;
			count++;
		}
	System.out.println(count);
	}
}
