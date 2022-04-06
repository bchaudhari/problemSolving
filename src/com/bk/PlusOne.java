package com.bk;

import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/plus-one/
 * 
   Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class PlusOne {
	// Top rated very simple solution in leetcode 
	public int[] plusOne(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	   
	    // This handles case of all 9s in input.
	    int[] newNumber = new int [n+1];
	    
	    // int array is initialized with all 0s so just need to set first index value to 1.
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
	public static void main(String[] args) {
		PlusOne plus1 = new PlusOne();
		Printer.printArray(plus1.plusOne(new int[] {1,2,3}));
		Printer.printArray(plus1.plusOne(new int[] {9}));
		Printer.printArray(plus1.plusOne(new int[] {2,9,9}));
		Printer.printArray(plus1.plusOne(new int[] {9,9,9}));
		Printer.printArray(plus1.plusOne(new int[] {9,8,9}));
	}

}
