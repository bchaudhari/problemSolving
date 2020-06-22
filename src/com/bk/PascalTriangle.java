package com.bk;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - https://leetcode.com/problems/pascals-triangle/
 * 
  Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class PascalTriangle {
	
	// Runtime: 0 ms
	// Faster than 100%
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		for(int i = 1; i <= numRows; i++) {
			int j = 1;
			int k = 0;
			List<Integer> temp = new ArrayList<Integer>();
			while(j <= i) {
				
				if(j == 1) {
					temp.add(1);
					result.add(temp);
				}
				else if(j == i) {
					temp.add(1);
				} 
				else {
					List<Integer> prev = result.get(i - 2);
					if(k < prev.size() - 1) {
						temp.add(prev.get(k) + prev.get(k+1));
						k++;
					}
				}
				j++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		System.out.println(pascalTriangle.generate(5));

	}

}
