package com.bk;

import com.bk.utils.Printer;

/***
 * 
https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MaximumSubArray {
	public int maxSubArray(int[] nums) {
        
        int maxSum=nums[0];
        int currentSum=maxSum;
         
        for(int i=1; i<nums.length; i++){
        	currentSum=Math.max(nums[i]+currentSum, nums[i]);
             maxSum=Math.max(currentSum, maxSum);
            
        }
        return maxSum;
    }
	
	// If you need to return indexes that makes maximum sum sub array
	public int[] maxSubArrayIndexes(int[] nums) {
        
        int maxSum=nums[0];
        int currentSum=maxSum;
        int[] indexes = new int[2];
        
        for(int i=1; i<nums.length; i++){
        	if(nums[i] > (currentSum + nums[i]))
                indexes[0] = i;
            currentSum=Math.max(nums[i]+currentSum, nums[i]);
            if(currentSum > maxSum)
                indexes[1] = i;
            maxSum=Math.max(currentSum, maxSum);
            
        }
        return indexes;
    }
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] nums = {31,-41,59,26,-53,58,97,-93,-23,84};
		
		MaximumSubArray msa = new MaximumSubArray();
		System.out.println(msa.maxSubArray(nums));
		Printer.printArray(msa.maxSubArrayIndexes(nums));
	}

}
