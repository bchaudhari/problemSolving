package com.bk;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - https://leetcode.com/problems/pascals-triangle-ii/submissions/
 * 
 Given a non-negative index k where k <= 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

Example:
Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class PascalTriangle2 {
	// O(n) space complexity
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}

	// Using recursion 
	// Runtime 0 ms
	// Faster than 100%
	// Memory Usage: 36.5 MB, less than 99.22% of submissions.
	// O(n2) space complexity
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		if(rowIndex == 0) {
			row.add(1);
			return row;
		} else {
			List<Integer> previousRow = getRow(rowIndex - 1);
			row.add(1);
			for(int i = 1; i < previousRow.size(); i++) {
				row.add(previousRow.get(i - 1) + previousRow.get(i));
			}
			row.add(1);
			return row;
		}
	}

	public static void main(String[] args) {
		PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
		System.out.println(pascalTriangle2.getRow(5));
	}

}
