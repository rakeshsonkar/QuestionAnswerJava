package sep;

import java.util.Arrays;

public class TestFinally {
	public static void main(String[] args) {
//		try {
//			System.out.println("Inside try");
//			return;
//		} finally {
//			System.out.println("Inside finally");
//		}
	double[] doubles= {1.23,150.1,45.7,456.5};
		
		double[] res =
			    Arrays.stream(doubles)
			          .collect(() -> new double[2],
			                   (arr, e) -> {arr[0]+=e; arr[1]+=e*e;},
			                   (arr1, arr2) -> {arr1[0]+=arr2[0]; arr1[1]+=arr2[1];});

			double sum = res[0];
			double sumOfSquares = res[1];
			
			System.out.println(sum+"    "+sumOfSquares);
	}

}
