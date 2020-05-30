package com.bk;

import java.util.Arrays;

import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class SquaresOfSortedArray {
	
	// Faster approach using two pointers
	// Without using Arrays.sort 
	// O(n)
	public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        int rIndex = A.length - 1;
        
        while(start <= end) {
        	int sqr1 = A[start] * A[start];
        	int sqr2 = A[end] * A[end];
        	
        	if(sqr1 > sqr2) {
        		result[rIndex--] = sqr1;
        		start++;
        	}
        	else {
        		result[rIndex--] = sqr2;
        		end--;
        	}
        }
        return result;
    }
	
	// O(n log n)
	public int[] sortedSquares1(int[] A) {
        int[] result = new int[A.length];
        int count = 0;
        for(int num: A){
            result[count++] = num * num;
        }
        Arrays.sort(result);
        return result;
    }
	public static void main(String[] args) {
		SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
		
		int[] arr1 = {-4,-1,0,3,10};
		int[] arr2 = {-7,-3,2,3,11};
		
		Printer.printArray(squaresOfSortedArray.sortedSquares(arr1));
		Printer.printArray(squaresOfSortedArray.sortedSquares(arr2));

	}

}
