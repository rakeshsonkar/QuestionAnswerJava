package sep.question;

import java.util.Scanner;

public class TransposeMatrix {
	public static void main(String[] args) {
		int row =0;
		int column =0;
		//int n,c,d;
		
		try (Scanner console = new Scanner(System.in)) {
			System.out.println("Enter the  number of rows and colums in matrix");
			row = console.nextInt();
			column = console.nextInt();
			
			int matrix[][] = new int[row][column];
			
			System.out.println("Enter the elements of matrix");
			for(int i=0;i<row;i++) {
				for(int j =0; j<column;j++) {
					matrix[i][j]=console.nextInt();
				}
			}
			System.out.println("Transpose of entred matrix ");
			
			int transpose[][] =transpose(matrix);
			for (int i = 0; i < column; i++) {
			    for (int j = 0; j < row; j++) {
			        System.out.printf("%s ", transpose[j][i]);
			    }
			    System.out.print("\n");
			}
		}
		
	}

	private static int[][] transpose(int[][] matrix) {
		int rows=matrix.length;
		int columns = matrix[0].length;
		int transpose[][] = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				transpose[j][i]= matrix[i][j];
			}
		}
		
		return matrix;
	}

}
