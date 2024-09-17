package july;

public class AverageWaitingTime {

	public static void main(String[] args) {
		int [][] customers1= {{1,2},{2,5},{4,3}};
		int [][] customers2= {{5,2},{5,4},{10,3},{20,1}};
		
		System.out.println(averageWaitingTime(customers1));
		System.out.println(averageWaitingTime(customers2));
	}

	private static Double averageWaitingTime(int[][] customers) {
		
		long totalWaitingTime =0;
		long currentTime =0;
		
		for(int[]customer:customers) {
			int arrivalTime=customer[0];
			int prepTime=customer[1];
			
			if(currentTime<arrivalTime) {
				currentTime=arrivalTime;
			}
			currentTime +=prepTime;
			totalWaitingTime+=currentTime-arrivalTime;
		}
		return (double) (totalWaitingTime/customers.length);
	}
}
