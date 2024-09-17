package july;

public class Bookshelf {

	 public int minHeightShelves(int[][] books, int shelfWidth) {
	        int n = books.length;
	        int[] dp = new int[n + 1];
	        
	        // dp[i] represents the minimum height needed to place the first i books
	        
	        for (int i = 1; i <= n; ++i) {
	            int width = 0;
	            int height = 0;
	            dp[i] = Integer.MAX_VALUE;
	            for (int j = i; j > 0; --j) {
	                width += books[j - 1][0];
	                if (width > shelfWidth) {
	                    break;
	                }
	                height = Math.max(height, books[j - 1][1]);
	                dp[i] = Math.min(dp[i], dp[j - 1] + height);
	            }
	        }
	        
	        return dp[n];
	    }

	    public static void main(String[] args) {
	        Bookshelf bookshelf = new Bookshelf();
	        
	        int[][] books1 = { {1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2} };
	        int shelfWidth1 = 4;
	        System.out.println(bookshelf.minHeightShelves(books1, shelfWidth1));  // Output: 6

	        int[][] books2 = { {1, 3}, {2, 4}, {3, 2} };
	        int shelfWidth2 = 6;
	        System.out.println(bookshelf.minHeightShelves(books2, shelfWidth2));  // Output: 4
	    }
	    
	    // Top-Down Dynamic Programming
	    
	    public static int TopDownDynamicProgramming(int [][] books,int shelfWidth) {
	    
	    	int[][] memo =  new int[books.length][shelfWidth+1];
	    	return dpHelper(books,shelfWidth,memo,0,shelfWidth,0);
	    }

		private static int dpHelper(
				int[][] books,
				int shelfWidth, 
				int[][] memo,
				int i,
				int remainingShelfWidth, 
				int maxHeight) {
		
			int[] currentBook = books[i];
			int maxHeightUpdated=Math.max(maxHeight,currentBook[1]);
			if(i==books.length -1) {
				// For the last book, store it in the current shelf if possible,
	            // or start a new shelf with it
				if(remainingShelfWidth >=currentBook[0])return maxHeightUpdated;
				return maxHeight +currentBook[1];
			}
			// Return answer if already computed
			if(memo[i][remainingShelfWidth] !=0) {
				return memo[i][remainingShelfWidth];
			}else {
				 // Calculate the height of the bookcase if we put the current book on the new shelf
				int option1Height = maxHeight + dpHelper(
						books,
						shelfWidth,
						memo,
						i+1,
						shelfWidth-currentBook[0],
						currentBook[1]
						);
				if(remainingShelfWidth >=currentBook[0]) {
					 // Calculate height of the bookcase if we put the current book on the current shelf
					int option2Height = dpHelper(books,
							shelfWidth,
							memo, 
							i+1, 
							remainingShelfWidth-currentBook[0],
							maxHeightUpdated);
				    // Store result in cache
					memo[i][remainingShelfWidth]=Math.min(option1Height, option2Height);
					return memo[i][remainingShelfWidth];
						
				}
				
				memo[i][remainingShelfWidth]=option1Height;
				return memo[i][remainingShelfWidth];
				
			}
		}
		
		
	// Bottom-Up Dynamic Programming
		
		public int BottomUpDynamicProgramming(int[][] books, int shelfWidth) {
			// dp[i] = minimum height of bookcase containing all books up to and
	        // excluding book i
			 int[] dp = new int[books.length + 1];
			 
			 // base cases
		        dp[0] = 0;
		        dp[1] = books[0][1];

		        for (int i = 2; i <= books.length; i++) {
		            // new shelf built to hold current book
		            int remainingShelfWidth = shelfWidth - books[i - 1][0];
		            int maxHeight = books[i - 1][1];
		            dp[i] = books[i - 1][1] + dp[i - 1];

		            int j = i - 1;
		            // calculate the height when previous books are added onto a new shelf
		            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
		                maxHeight = Math.max(maxHeight, books[j - 1][1]);
		                remainingShelfWidth -= books[j - 1][0];
		                dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
		                j--;
		            }
		        }

		        return dp[books.length];
		}
		
}
