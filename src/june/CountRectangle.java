package june;

import java.util.stream.IntStream;

public class CountRectangle {
	public static int countRectangles(int r) {
        // Calculate the number of valid rectangles that can fit inside the circle
        return (int) IntStream.rangeClosed(1, 2 * r)
            .flatMap(l -> IntStream.rangeClosed(1, 2 * r)
                .filter(w -> (l * l + w * w) <= 4 * r * r))
            .count();
    }
	 public static void main(String[] args) {
	        int r1 = 1;
	        System.out.println(countRectangles(r1)); // Output: 1

	        int r2 = 2;
	        System.out.println(countRectangles(r2)); // Output: 8
	    }
	 
	 public static int countRectangleExam(int r) {
	        int count = 0;
	        for (int l = 1; l <= 2 * r; l++) {
	            for (int w = 1; w <= 2 * r; w++) {
	                if ((l * l) + (w * w) <= 4 * r * r) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
}
