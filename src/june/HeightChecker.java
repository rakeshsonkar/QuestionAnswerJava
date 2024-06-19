package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeightChecker {

	public static int heightChecker(List<Integer> heights) {
       
        List<Integer> expected = new ArrayList<>(heights);
        Collections.sort(expected);
      
        int mismatchCount = 0;
        

        for (int i = 0; i < heights.size(); i++) {
            if (!heights.get(i).equals(expected.get(i))) {
                mismatchCount++;
            }
        }
        
        return mismatchCount;
    }
	
	
	public static int heightCheckerWithoutCollection(int[] heights) {
        int length = heights.length;
        int[] newHeights = Arrays.copyOf(heights, length);
        
        Arrays.sort(newHeights);

        int difference = 0;
        for (int index = 0; index < length; index++) {
            if (heights[index] != newHeights[index])
                difference++;
        }

        return difference;
    }

    public static void main(String[] args) {
      
        List<Integer> heights1 = new ArrayList<>(List.of(1, 1, 4, 2, 1, 3));
        System.out.println(heightChecker(heights1));  // Output: 3

        List<Integer> heights2 = new ArrayList<>(List.of(5, 1, 2, 3, 4));
        System.out.println(heightChecker(heights2));  // Output: 5

        List<Integer> heights3 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(heightChecker(heights3));  // Output: 0
        
        
       int[] heights4 = {1, 2, 3, 4, 5};
        System.out.println(heightCheckerWithoutCollection(heights4));  // Output: 0
    }

}
