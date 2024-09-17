package july;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MaximumConnectedGroup {
	 private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	    private static int n;
	    
	    public static void main(String[] args) {
	        int[][] grid1 = {{1, 1}, {0, 1}};
	        int[][] grid2 = {{1, 0, 1}, {1, 0, 1}, {1, 0, 1}};
	        System.out.println(largestConnectedGroup(grid1)); // Output: 4
	        System.out.println(MaxConnection(grid2)); // Output: 7
	    }
	    public static int largestConnectedGroup(int[][] grid) {
	        n = grid.length;
	        boolean[][] visited = new boolean[n][n];
	        int maxConnected = 0;
	        
	        // Step 1: Find all connected components of 1's in the original grid
	        Map<Integer, Integer> areaMap = new HashMap<>();
	        int componentId = 2;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (grid[i][j] == 1 && !visited[i][j]) {
	                    int area = dfs(grid, visited, i, j, componentId);
	                    areaMap.put(componentId, area);
	                    maxConnected = Math.max(maxConnected, area);
	                    componentId++;
	                }
	            }
	        }

	        // Step 2: Check each cell with 0 and calculate the potential largest group of connected 1's
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (grid[i][j] == 0) {
	                    Set<Integer> neighboringComponents = new HashSet<>();
	                    for (int[] dir : directions) {
	                        int ni = i + dir[0], nj = j + dir[1];
	                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
	                            neighboringComponents.add(grid[ni][nj]);
	                        }
	                    }
	                    int potentialArea = 1; // The cell (i, j) that we are converting from 0 to 1
	                    for (int compId : neighboringComponents) {
	                        potentialArea += areaMap.get(compId);
	                    }
	                    maxConnected = Math.max(maxConnected, potentialArea);
	                }
	            }
	        }

	        return maxConnected;
	    }
	    
	    private static int dfs(int[][] grid, boolean[][] visited, int i, int j, int componentId) {
	        Stack<int[]> stack = new Stack<>();
	        stack.push(new int[]{i, j});
	        visited[i][j] = true;
	        grid[i][j] = componentId;
	        int area = 0;

	        while (!stack.isEmpty()) {
	            int[] cell = stack.pop();
	            int x = cell[0], y = cell[1];
	            area++;

	            for (int[] dir : directions) {
	                int nx = x + dir[0], ny = y + dir[1];
	                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] == 1) {
	                    visited[nx][ny] = true;
	                    grid[nx][ny] = componentId;
	                    stack.push(new int[]{nx, ny});
	                }
	            }
	        }

	        return area;
	    }
	    
	    
	    static int dfs(int[][] grid,int i,int j,int n,int islandNo){
	        if(i < 0 || j < 0 || i >= n ||j >= n || grid[i][j]==0 || grid[i][j]==islandNo){
	            return 0;
	        }
	        grid[i][j]=islandNo;
	        int a=dfs(grid,i-1,j,n,islandNo);
	        int b=dfs(grid,i,j-1,n,islandNo);
	        int c=dfs(grid,i+1,j,n,islandNo);
	        int d=dfs(grid,i,j+1,n,islandNo);
	        
	        return 1+a+b+c+d;
	    }

	    public static int MaxConnection(int grid[][]) {
	        int n=grid.length;
	        int islandNo=2;
	        int ans=0;
	        Map<Integer,Integer> map = new  HashMap<>();
	        for(int i=0;i<n;++i){
	            for(int j=0;j<n;++j){
	                if(grid[i][j]==1){
	                    int size;
							size = dfs(grid,i,j,n,islandNo);
	                    map.put(islandNo,size);
	                    ans=Math.max(ans,size);
	                    islandNo++;
	                }
	            }
	        }
	        for(int i=0;i<n;++i){
	            for(int j=0;j<n;++j){
	                Set<Integer> set= new  HashSet<>();
	                int maxSize=0;
	                if(grid[i][j]==0){
	                    if(i>0){
	                        set.add(grid[i-1][j]);
	                    }
	                     if(i<n-1){
	                        set.add(grid[i+1][j]);
	                    }
	                    if(j>0){
	                        set.add(grid[i][j-1]);
	                    }
	                     if(j<n-1){
	                        set.add(grid[i][j+1]);
	                    }
	                }
	                for(Integer s:set){
	                    maxSize+=map.get(s)==null?0:map.get(s);
	                }
	                maxSize++;
	                ans=Math.max(maxSize,ans);
	            }
	        }
	        return ans;
	    }

}
