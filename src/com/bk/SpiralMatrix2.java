package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/spiral-matrix-ii/
 * 
 Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class SpiralMatrix2 {
	 public int[][] generateMatrix(int n) {
		 	// Creating m x n matrix where m = n 
	        int m = n; // m row end index, n column end index
	        int ms = 0; // row start index
	        int ns = 0; // column start index
	        int counter = 1; // counter to print numbers
	        int[][] a = new int[m][n];
	        while(ms < m && ns < n) {
	        	int i;
	        	for(i = ns; i < n; i++) {
	        		a[ms][i] = counter++;
	        	}
	        	ms++;
	        	
	        	for(i = ms; i < m; i++) {
	        		a[i][n-1] = counter++;
	        	}
	        	n--;
	        	
	        	if(ms < m && ns < n) {
	        		for(i = n-1; i >= ns; i--) {
	        			a[m-1][i] = counter++;
	        		}
	        		m--;
	        		for(i = m-1; i >= ms; i--) {
	        			a[i][ns] = counter++;
	        		}
	        		ns++;
	        	}
	        }
	        return a;
	    }
	public static void main(String[] args) {
		SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
		spiralMatrix2.generateMatrix(3);
		spiralMatrix2.generateMatrix(5);
		spiralMatrix2.generateMatrix(1);

	}

}
