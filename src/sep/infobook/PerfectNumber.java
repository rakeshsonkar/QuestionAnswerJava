package sep.infobook;

public class PerfectNumber {
	public static void main(String[] args) 
	{
	int number=7;
		 boolean result = isPerfect(number);

         if (result) {
             System.out.printf("%d is a perfect number %n", number);
         } else {
             System.out.printf("%d is not a perfect number %n", number);
         }
	}

	public  static boolean isPerfect(int number) {
		int sumOfDivisors=0;
		int copyOfInput = number;
		
		for(int i =1; i<=copyOfInput/2;i++) {
			if(copyOfInput % i == 0) {
				sumOfDivisors += i;
			}
		}
		return number == sumOfDivisors;
	}
}
