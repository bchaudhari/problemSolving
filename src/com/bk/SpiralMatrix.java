package com.bk;

import java.util.ArrayList;
import java.util.List;

/***
 * Leetcode - https://leetcode.com/problems/spiral-matrix/
 * 
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int m = matrix.length; // Row End
		if(m == 0) return result;
		int n = matrix[0].length; // Column End
		int ms = 0; // Row start
		int ns = 0; // Column start

		while(ms < m && ns < n) {
			int i;
			// Print First row
			for(i = ns; i < n; i++) {
				result.add(matrix[ms][i]);
				System.out.print(matrix[ms][i] + " ");
			}
			ms++;

			// Print last column
			for(i = ms; i <= m -1; i++) {
				result.add(matrix[i][n-1]);
				System.out.print(matrix[i][n-1] + " ");
			}
			n--;

			if(ms < m && ns < n) {
				// Print last row (except first column element)
				for(i = n-1; i > ns; i--) {
					result.add(matrix[m-1][i]);
					System.out.print(matrix[m-1][i] + " ");
				}
				m--;

				// Print first column
				for(i = m; i >= ms; i--) {
					result.add(matrix[i][ns]);
					System.out.print(matrix[i][ns] + " ");
				}
				ns++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] mat1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		int[][] mat2 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9,10,11,12}
		};
		int[][] mat3 = {
				{3},
				{2}
		};
		int[][] mat4 = {
				{6,9,7}
		};

		SpiralMatrix spiralMatrix = new SpiralMatrix();
		spiralMatrix.spiralOrder(mat1);
		System.out.print("\n");
		spiralMatrix.spiralOrder(mat2);
		System.out.print("\n");
		spiralMatrix.spiralOrder(mat3);
		System.out.print("\n");
		spiralMatrix.spiralOrder(mat4);
	}

}
