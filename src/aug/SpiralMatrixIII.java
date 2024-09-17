package aug;

public class SpiralMatrixIII {

	public static void main(String[] args) {
		int rows = 5, cols = 6, rStart = 1, cStart = 4;
		
		System.out.println(spiralMatrixIII(rows,cols,rStart,cStart));
		System.out.println(simulationSpiralMatrixIII(rows,cols,rStart,cStart));
		
	}

	private static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int total=rows*cols;
		int[][] res = new int[total][2];
		int i=1;
		int [][] dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		int d=0;
		int moves=0;
		int x=rStart;
		int y=cStart;
		res[0] =new int[] {rStart,cStart};
		while(i<res.length) {
			int steps=(moves/2)+1;
			for (int j = 0; j < steps; j++) {
				x += dirs[d][0];
				y += dirs[d][1];
				if(x >=0 && x<rows && y >= 0 && y < cols) {
					res[i++]=new int[] {x,y};
				}
			}
			moves++;
			d= (d+1) % 4;
		}
		return res;
	}
	private static int[][] simulationSpiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		// Store all possible directions in an array.
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] traversed = new int[rows * cols][2];
        int idx = 0;
        // Initial step size is 1, value of d represents the current direction.
        for (int step = 1, direction = 0; idx < rows * cols;) {
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    // Validate the current position
                    if (
                        rStart >= 0 &&
                        rStart < rows &&
                        cStart >= 0 &&
                        cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        ++idx;
                    }
                    // Make changes to the current position.
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return traversed;
	}
	
}
