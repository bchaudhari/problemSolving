package com.bk;

import java.util.Hashtable;

import com.bk.utils.Printer;

/***
 * Leetcode - https://leetcode.com/problems/two-sum/
 * 
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
		int[] result = new int[2];
		for(int i = 0; i < nums.length; i++) {
			if(!hm.containsKey(nums[i])) {
				hm.put(target - nums[i], i);
			} else {
				result[0] = hm.get(nums[i]);
				result[1] = i;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {2, 7, 11, 15};
		int target1 = 9;
		
		TwoSum twoSum = new TwoSum();
		Printer.printArray(twoSum.twoSum(nums1, target1));
	}
}
