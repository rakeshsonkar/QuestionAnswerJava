package june.swap;

public class EvenAndOddDigits {

	public static void main(String[] args) {
		int num=123465675;
		
		int even=0;
		int odd=0;
		while(num>0) {
			int rem=num%10;
			if(rem%2==0) {
				even++;
			}else {
				odd++;
			}
			num=num/10;
		}
		
		System.out.println(even);
		System.out.println(odd);
	}
}
