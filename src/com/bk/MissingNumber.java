/**
 * 
 */
package com.bk;

import java.util.Arrays;

/**
 * Leetcode - https://leetcode.com/problems/missing-number/submissions/
 * 
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MissingNumber {
	// Faster Solution
	public int missingNumber(int[] nums) {
		int n = nums.length; 
        int expectedSum = (n*(n+1))/2;
        int actualSum = 0;
        for(int x: nums)
        	actualSum = actualSum + x;
        return expectedSum - actualSum;       
    }
	
	public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] != i)
                break;
        }
        return i;
    }
	
	public static void main(String[] args) {
		MissingNumber missingNumber = new MissingNumber();
		int[] a1 = {9,6,4,2,3,5,7,0,1};
		System.out.println("Expected 8 found --> "+ missingNumber.missingNumber(a1));

	}

}
