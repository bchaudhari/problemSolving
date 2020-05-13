package com.bk;

import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/move-zeroes/
 * 
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MoveZeros {

	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int zeroCounter = 0;
		for(int i = 0; i < n; i++) {
			if(nums[i] == 0) {
				zeroCounter++;
			} else {
				shiftNumber(nums, i, zeroCounter);// Shift number to left by zeroCounter positions
			}
		}
		
		// Add zeros to end
		for(int i = 1; i <= zeroCounter; i++) {
			nums[n-i] = 0;
		}
	}
	
	public void shiftNumber(int[] nums, int numPosition, int positions) {
		if(positions == 0) {
			return;
		} 
		
		nums[numPosition - positions] = nums[numPosition];
	}

	public static void main(String[] args) {
		int[] nums1 = {0,1,0,3,12};
		
		MoveZeros move = new MoveZeros();
		move.moveZeroes(nums1);
		Printer.printArray(nums1);
	}

}
