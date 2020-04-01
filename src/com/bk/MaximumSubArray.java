package com.bk;

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
//	public int maxSubArray(int[] nums) {
//		int maxSum = 0;
//		int sum = 0;
//
//		int n = nums.length;
//		int subArraySize = (int)Math.sqrt(n);
//		
//		int start = 0;
//		int end = subArraySize;
//		int count = 0;
//		boolean firstSub = true;
//		for(int i = 0; i < n; i++) {
//			count++;
//			sum = sum + nums[i];
//			if(count % subArraySize == 0 || count == n) {
//				if(firstSub || sum > maxSum) {
//					maxSum = sum;
//					end = i;
//					start = i - subArraySize + 1;
//					firstSub = false;
//				}
//				
//				sum = 0;
//			}
//		}
//
//		sum = maxSum;
//
//		// Increase left boundary of subArray till sum keeps increasing
//		while(start > 0 && sum >= maxSum) {
//			start = start - 1;
//			sum = sum + nums[start];
//			if(sum < maxSum) {
//				start = start +1;
//			} else {
//				maxSum = sum;
//			}
//		}
//
//		sum = maxSum;
//
//		// Increase right boundary of subArray till sum keeps increasing
//		while(end < n-1 && sum >= maxSum) {
//			end = end + 1;
//			sum = sum + nums[end];
//			if(sum < maxSum) {
//				end = end - 1;
//			} else {
//				maxSum = sum;
//			}
//		}
//		return maxSum;
//	}
	public int maxSubArray1(int[] nums) {
        
        int maxSum=nums[0];
        int currentSum=maxSum;
        
        for(int i=1; i<nums.length; i++){
            currentSum=Math.max(nums[i]+currentSum, nums[i]);
            maxSum=Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
	public static void main(String[] args) {
//		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {31,-41,59,26,-53,58,97,-93,-23,84};
		
		MaximumSubArray msa = new MaximumSubArray();
		System.out.println(msa.maxSubArray1(nums));
	}

}
