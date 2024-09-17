package july.methodreference;

public class Main {

	public static void main(String[] args) {
		Isum isum=new Isum() {
			
			@Override
			public int sum(int val1, int val2) {
				// TODO Auto-generated method stub
				return val1 + val2;
			}
		};
		
		int sum = isum.sum(10, 10);
		System.out.println(sum);
		
		// LambdaWay 
		/*
		 * Isum isumLambdaWay = (val1,val2)->{ return val1+val2; };
		 */
		Isum isumLambdaWay = (val1,val2)-> val1+val2;
		System.out.println(isumLambdaWay.sum(20, 20));
		
		//Method reference 
		Isum isum2 = Integer::sum;
		int sum2= isum2.sum(100, 200);
		System.out.println(sum2);
		
			
	}
}
